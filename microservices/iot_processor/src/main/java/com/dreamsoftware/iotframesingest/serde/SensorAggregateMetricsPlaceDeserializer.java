package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregatePlaceMetricsDTO;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsPlaceDeserializer extends SupportSerDer<SensorAggregatePlaceMetricsDTO> implements Deserializer<SensorAggregatePlaceMetricsDTO> {

    public SensorAggregateMetricsPlaceDeserializer() {
        super(SensorAggregatePlaceMetricsDTO.class);
    }

    @Override
    public SensorAggregatePlaceMetricsDTO deserialize(String string, byte[] bytes) {
        return this.deserialize(bytes);
    }

}
