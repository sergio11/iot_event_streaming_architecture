package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregatePlaceMetricsDTO;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsPlaceSerializer extends SupportSerDer<SensorAggregatePlaceMetricsDTO> implements Serializer<SensorAggregatePlaceMetricsDTO> {

    public SensorAggregateMetricsPlaceSerializer() {
        super(SensorAggregatePlaceMetricsDTO.class);
    }

    @Override
    public byte[] serialize(String string, SensorAggregatePlaceMetricsDTO sensorAggregateData) {
        return this.serialize(sensorAggregateData);
    }

}
