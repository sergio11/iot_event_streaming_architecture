package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ssanchez
 */
public class SensorDataSerializer implements Serializer<SensorDataDTO> {

    private static final Logger logger = LoggerFactory.getLogger(SensorDataSerializer.class);

    @Override
    public byte[] serialize(String string, SensorDataDTO sensorData) {

        logger.debug("Serialize Data -> " + string);

        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(sensorData).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
