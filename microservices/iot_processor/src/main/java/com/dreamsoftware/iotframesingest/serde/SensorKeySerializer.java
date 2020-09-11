package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorKeySerializer extends SupportSerDer<SensorKeyDTO> implements Serializer<SensorKeyDTO> {

    public SensorKeySerializer() {
        super(SensorKeyDTO.class);
    }

    @Override
    public byte[] serialize(String string, SensorKeyDTO sensorKey) {
        return this.serialize(sensorKey);
    }

}
