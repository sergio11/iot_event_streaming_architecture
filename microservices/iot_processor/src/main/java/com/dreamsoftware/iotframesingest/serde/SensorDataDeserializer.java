package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorDataDeserializer implements Deserializer<SensorDataDTO> {

    @Override
    public SensorDataDTO deserialize(String string, byte[] bytes) {

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
