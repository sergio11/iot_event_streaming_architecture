package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorTimeSerieMetricDTO;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorTimeSerieMetricSerializer extends SupportSerDer<SensorTimeSerieMetricDTO> implements Serializer<SensorTimeSerieMetricDTO> {

    public SensorTimeSerieMetricSerializer() {
        super(SensorTimeSerieMetricDTO.class);
    }

    @Override
    public byte[] serialize(String string, SensorTimeSerieMetricDTO sensorTimeSerieMetric) {
        return this.serialize(sensorTimeSerieMetric);
    }

}
