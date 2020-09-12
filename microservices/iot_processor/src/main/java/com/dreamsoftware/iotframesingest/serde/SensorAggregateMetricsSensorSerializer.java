package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateSensorMetricsDTO;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsSensorSerializer extends SupportSerDer<SensorAggregateSensorMetricsDTO> implements Serializer<SensorAggregateSensorMetricsDTO> {

    public SensorAggregateMetricsSensorSerializer() {
        super(SensorAggregateSensorMetricsDTO.class);
    }

    @Override
    public byte[] serialize(String string, SensorAggregateSensorMetricsDTO sensorAggregateData) {
        return this.serialize(sensorAggregateData);
    }

}
