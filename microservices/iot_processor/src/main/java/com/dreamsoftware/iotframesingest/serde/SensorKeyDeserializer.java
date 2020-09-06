package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorKeyDeserializer implements Deserializer<SensorKeyDTO> {

    @Override
    public SensorKeyDTO deserialize(String string, byte[] bytes) {

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
