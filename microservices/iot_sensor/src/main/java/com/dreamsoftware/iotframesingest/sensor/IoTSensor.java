package com.dreamsoftware.iotframesingest.sensor;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.dreamsoftware.iotframesingest.model.SensorDataPayloadDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssanchez
 */
@Component
public class IoTSensor implements Callable<Void> {

    private static final Logger logger = LoggerFactory.getLogger(IoTSensor.class);

    private final IMqttClient mqttClient;
    private final ObjectMapper objectMapper;

    @Value("${mqtt.server.topic}")
    private String mqttTopic;
    @Value("${sensor.name}")
    private String sensorName;
    @Value("${sensor.id}")
    private String sensorId;
    @Value("${sensor.place.id}")
    private String sensorPlaceId;

    private final Random rnd = new Random();

    /**
     *
     * @param mqttClient
     * @param objectMapper
     */
    @Autowired
    public IoTSensor(final IMqttClient mqttClient, final ObjectMapper objectMapper) {
        this.mqttClient = mqttClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Void call() throws Exception {
        if (!mqttClient.isConnected()) {
            return null;
        }
        mqttClient.publish(mqttTopic, buildMessage());
        return null;
    }

    /**
     * Build MQTT Message
     *
     * @return
     * @throws JsonProcessingException
     */
    private MqttMessage buildMessage() throws JsonProcessingException {

        //Generate Sensor Values
        int temperature = rnd.ints(-5, 35).findFirst().getAsInt();
        int humidity = rnd.ints(0, 100).findFirst().getAsInt();
        int pressure = rnd.ints(1000, 1030).findFirst().getAsInt();
        int luminosity = rnd.ints(0, 65000).findFirst().getAsInt();

        // Generate Payload
        final SensorDataDTO data = SensorDataDTO.builder()
                .id(sensorId)
                .name(sensorName)
                .placeId(sensorPlaceId)
                .date(new Date())
                .timestamp(new Date().getTime())
                .payload(SensorDataPayloadDTO.builder()
                        .humidity(humidity)
                        .luminosity(luminosity)
                        .pressure(pressure)
                        .temperature(temperature)
                        .build())
                .build();

        final String payload = objectMapper.writeValueAsString(data);

        logger.debug("Payload -> " + payload);

        // Create and configure MQTT Message
        final MqttMessage message = new MqttMessage(payload.getBytes(Charset.forName("UTF-8")));
        message.setQos(1);
        message.setRetained(true);
        return message;
    }

}
