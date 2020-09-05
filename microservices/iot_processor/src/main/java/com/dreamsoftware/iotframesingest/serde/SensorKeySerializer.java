package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ssanchez
 */
public class SensorKeySerializer implements Serializer<SensorKeyDTO> {

    private static final Logger logger = LoggerFactory.getLogger(SensorKeySerializer.class);

    @Override
    public byte[] serialize(String string, SensorKeyDTO sensorKey) {

        logger.debug("Serialize Key -> " + string);

        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(sensorKey).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
