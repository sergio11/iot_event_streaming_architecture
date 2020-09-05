package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ssanchez
 */
public class SensorDataDeserializer implements Deserializer<SensorDataDTO> {

    private static final Logger logger = LoggerFactory.getLogger(SensorDataDeserializer.class);

    @Override
    public SensorDataDTO deserialize(String string, byte[] bytes) {

        logger.debug("Deserialize Sensor Data -> " + string);

        ObjectMapper mapper = new ObjectMapper();
        SensorDataDTO sensorData = null;
        try {
            sensorData = mapper.readValue(bytes, SensorDataDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sensorData;
    }

}
