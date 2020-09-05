package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ssanchez
 */
public class SensorKeyDeserializer implements Deserializer<SensorKeyDTO> {

    private static final Logger logger = LoggerFactory.getLogger(SensorKeyDeserializer.class);

    @Override
    public SensorKeyDTO deserialize(String string, byte[] bytes) {

        logger.debug("Deserialize Sensor Key -> " + string);

        ObjectMapper mapper = new ObjectMapper();
        SensorKeyDTO sensorKey = null;
        try {
            sensorKey = mapper.readValue(bytes, SensorKeyDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sensorKey;
    }

}
