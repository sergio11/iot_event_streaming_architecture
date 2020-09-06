package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsDeserializer implements Deserializer<SensorAggregateMetricsDTO> {

    @Override
    public SensorAggregateMetricsDTO deserialize(String string, byte[] bytes) {

        ObjectMapper mapper = new ObjectMapper();
        SensorAggregateMetricsDTO sensorData = null;
        try {
            sensorData = mapper.readValue(bytes, SensorAggregateMetricsDTO.class);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return sensorData;
    }

}
