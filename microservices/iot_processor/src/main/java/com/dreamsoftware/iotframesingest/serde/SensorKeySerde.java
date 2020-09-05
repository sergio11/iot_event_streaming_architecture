package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorKeySerde implements Serde<SensorKeyDTO> {

    @Override
    public Serializer<SensorKeyDTO> serializer() {
        return new SensorKeySerializer();
    }

    @Override
    public Deserializer<SensorKeyDTO> deserializer() {
        return new SensorKeyDeserializer();
    }

}
