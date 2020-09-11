package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsDeserializer extends SupportSerDer<SensorAggregateMetricsDTO> implements Deserializer<SensorAggregateMetricsDTO> {

    public SensorAggregateMetricsDeserializer() {
        super(SensorAggregateMetricsDTO.class);
    }

    @Override
    public SensorAggregateMetricsDTO deserialize(String string, byte[] bytes) {
        return this.deserialize(bytes);
    }

}
