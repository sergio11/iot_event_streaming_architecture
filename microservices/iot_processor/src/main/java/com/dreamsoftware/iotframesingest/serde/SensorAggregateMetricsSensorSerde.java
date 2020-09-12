package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateSensorMetricsDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsSensorSerde implements Serde<SensorAggregateSensorMetricsDTO> {

    @Override
    public Serializer<SensorAggregateSensorMetricsDTO> serializer() {
        return new SensorAggregateMetricsSensorSerializer();
    }

    @Override
    public Deserializer<SensorAggregateSensorMetricsDTO> deserializer() {
        return new SensorAggregateMetricsSensorDeserializer();
    }

}
