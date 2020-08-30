package com.dreamsoftware.iotframesingest.sensor;

import com.dreamsoftware.iotframesingest.model.SensorTemperatureDataDTO;
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
public class EngineTemperatureSensor implements Callable<Void> {

    private static final Logger logger = LoggerFactory.getLogger(EngineTemperatureSensor.class);

    private final IMqttClient mqttClient;
    private final ObjectMapper objectMapper;

    @Value("${mqtt.server.topic}")
    private String mqttTopic;
    @Value("${sensor.name}")
    private String sensorName;
    @Value("${sensor.id}")
    private String sensorId;

    private final Random rnd = new Random();

    /**
     *
     * @param mqttClient
     * @param objectMapper
     */
    @Autowired
    public EngineTemperatureSensor(final IMqttClient mqttClient, final ObjectMapper objectMapper) {
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

        // Generate Random Temperature
        double temp = 80 + rnd.nextDouble() * 20.0;

        // Generate Payload
        final SensorTemperatureDataDTO data = SensorTemperatureDataDTO.builder()
                .id(sensorId)
                .name(sensorName)
                .temperature(String.format("T:%04.2f", temp))
                .date(new Date())
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
