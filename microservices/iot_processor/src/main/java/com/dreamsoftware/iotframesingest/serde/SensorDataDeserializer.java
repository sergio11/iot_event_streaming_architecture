package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author ssanchez
 */
public class SensorDataDeserializer extends SupportSerDer<SensorDataDTO> implements Deserializer<SensorDataDTO> {

    public SensorDataDeserializer() {
        super(SensorDataDTO.class);
    }

    @Override
    public SensorDataDTO deserialize(String string, byte[] bytes) {
        return this.deserialize(bytes);
    }

}
