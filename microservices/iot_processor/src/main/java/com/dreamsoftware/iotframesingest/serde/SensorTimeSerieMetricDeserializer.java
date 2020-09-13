package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorTimeSerieMetricDTO;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorTimeSerieMetricDeserializer extends SupportSerDer<SensorTimeSerieMetricDTO> implements Deserializer<SensorTimeSerieMetricDTO> {

    public SensorTimeSerieMetricDeserializer() {
        super(SensorTimeSerieMetricDTO.class);
    }

    @Override
    public SensorTimeSerieMetricDTO deserialize(String string, byte[] bytes) {
        return this.deserialize(bytes);
    }

}
