package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsSerializer extends SupportSerDer<SensorAggregateMetricsDTO> implements Serializer<SensorAggregateMetricsDTO> {

    public SensorAggregateMetricsSerializer() {
        super(SensorAggregateMetricsDTO.class);
    }

    @Override
    public byte[] serialize(String string, SensorAggregateMetricsDTO sensorAggregateData) {
        return this.serialize(sensorAggregateData);
    }

}
