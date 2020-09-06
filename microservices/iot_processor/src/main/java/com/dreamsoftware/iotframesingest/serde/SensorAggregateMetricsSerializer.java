package com.dreamsoftware.iotframesingest.serde;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ssanchez
 */
public class SensorAggregateMetricsSerializer implements Serializer<SensorAggregateMetricsDTO> {

    private static final Logger logger = LoggerFactory.getLogger(SensorAggregateMetricsSerializer.class);

    @Override
    public byte[] serialize(String string, SensorAggregateMetricsDTO sensorAggregateData) {

        logger.debug("Serialize Data to topic -> " + string);

        logger.debug("Aggregate Count Measures-> " + sensorAggregateData.getCountMeasures());
        logger.debug("Aggregate Avg Temperature -> " + sensorAggregateData.getAvgTemperature());
        logger.debug("Aggregate Avg Humidity -> " + sensorAggregateData.getAvgHumidity());
        logger.debug("Aggregate Avg Luminosity -> " + sensorAggregateData.getAvgLuminosity());
        logger.debug("Aggregate Avg Pressure -> " + sensorAggregateData.getAvgPressure());

        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(sensorAggregateData).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
