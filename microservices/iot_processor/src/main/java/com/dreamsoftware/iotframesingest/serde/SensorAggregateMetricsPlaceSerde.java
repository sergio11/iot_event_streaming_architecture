package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregatePlaceMetricsDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsPlaceSerde implements Serde<SensorAggregatePlaceMetricsDTO> {

    @Override
    public Serializer<SensorAggregatePlaceMetricsDTO> serializer() {
        return new SensorAggregateMetricsPlaceSerializer();
    }

    @Override
    public Deserializer<SensorAggregatePlaceMetricsDTO> deserializer() {
        return new SensorAggregateMetricsPlaceDeserializer();
    }

}
