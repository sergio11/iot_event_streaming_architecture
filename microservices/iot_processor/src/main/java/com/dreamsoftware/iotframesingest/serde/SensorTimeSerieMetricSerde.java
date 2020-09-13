package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorTimeSerieMetricDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorTimeSerieMetricSerde implements Serde<SensorTimeSerieMetricDTO> {

    @Override
    public Serializer<SensorTimeSerieMetricDTO> serializer() {
        return new SensorTimeSerieMetricSerializer();
    }

    @Override
    public Deserializer<SensorTimeSerieMetricDTO> deserializer() {
        return new SensorTimeSerieMetricDeserializer();
    }

}
