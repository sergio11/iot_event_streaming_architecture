package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author ssanchez
 */
public class SensorDataSerializer extends SupportSerDer<SensorDataDTO> implements Serializer<SensorDataDTO> {

    public SensorDataSerializer() {
        super(SensorDataDTO.class);
    }

    @Override
    public byte[] serialize(String string, SensorDataDTO sensorData) {
        return this.serialize(sensorData);
    }

}
