package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorKeyDeserializer extends SupportSerDer<SensorKeyDTO> implements Deserializer<SensorKeyDTO> {

    public SensorKeyDeserializer() {
        super(SensorKeyDTO.class);
    }

    @Override
    public SensorKeyDTO deserialize(String string, byte[] bytes) {
        return this.deserialize(bytes);
    }

}
