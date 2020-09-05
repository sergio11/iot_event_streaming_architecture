package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorDataSerde implements Serde<SensorDataDTO> {

    @Override
    public Serializer<SensorDataDTO> serializer() {
        return new SensorDataSerializer();
    }

    @Override
    public Deserializer<SensorDataDTO> deserializer() {
        return new SensorDataDeserializer();
    }

}
