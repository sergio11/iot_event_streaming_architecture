package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsSerde implements Serde<SensorAggregateMetricsDTO> {

    @Override
    public Serializer<SensorAggregateMetricsDTO> serializer() {
        return new SensorAggregateMetricsSerializer();
    }

    @Override
    public Deserializer<SensorAggregateMetricsDTO> deserializer() {
        return new SensorAggregateMetricsDeserializer();
    }

}
