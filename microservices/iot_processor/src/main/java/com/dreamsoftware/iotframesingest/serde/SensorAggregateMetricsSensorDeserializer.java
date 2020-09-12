package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateSensorMetricsDTO;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsSensorDeserializer extends SupportSerDer<SensorAggregateSensorMetricsDTO> implements Deserializer<SensorAggregateSensorMetricsDTO> {

    public SensorAggregateMetricsSensorDeserializer() {
        super(SensorAggregateSensorMetricsDTO.class);
    }

    @Override
    public SensorAggregateSensorMetricsDTO deserialize(String string, byte[] bytes) {
        return this.deserialize(bytes);
    }

}
