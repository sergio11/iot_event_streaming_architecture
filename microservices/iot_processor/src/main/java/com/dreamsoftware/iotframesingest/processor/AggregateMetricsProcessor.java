package com.dreamsoftware.iotframesingest.processor;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import com.dreamsoftware.iotframesingest.serde.SensorAggregateMetricsSerde;
import com.dreamsoftware.iotframesingest.serde.SensorKeySerde;
import java.time.Duration;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Aggreate Metrics Processor
 *
 * @author ssanchez
 */
@Component
public class AggregateMetricsProcessor {

    private static final Logger logger = LoggerFactory.getLogger(AggregateMetricsProcessor.class);

    private final static int WINDOW_TIME_IN_MINUTES = 5;

    @Value("${kafka.topic.aggregate-metrics}")
    private String outputTopic;

    /**
     *
     * @param stream
     */
    public void process(KStream<SensorKeyDTO, SensorDataDTO> stream) {

        final KTable<Windowed<SensorKeyDTO>, SensorAggregateMetricsDTO> aggregateMetricsBySensor = buildAggregateMetricsBySensor(stream);

        aggregateMetricsBySensor.toStream(new KeyValueMapper<Windowed<SensorKeyDTO>, SensorAggregateMetricsDTO, KeyValue<SensorKeyDTO, SensorAggregateMetricsDTO>>() {
            @Override
            public KeyValue<SensorKeyDTO, SensorAggregateMetricsDTO> apply(Windowed<SensorKeyDTO> k, SensorAggregateMetricsDTO v) {
                logger.debug("Sensor Name -> " + v.getName() + " Sensor Count Measures -> " + v.getCountMeasures());
                logger.debug("Sensor Avg Temperature -> " + v.getSumTemperature());
                logger.debug("Sensor Avg Humidity -> " + v.getAvgHumidity());
                logger.debug("Sensor Avg Luminosity -> " + v.getAvgLuminosity());
                logger.debug("Sensor Avg Pressure -> " + v.getAvgPressure());

                return new KeyValue<>(k.key(), v);
            }

        });
    }

    /**
     *
     * @param stream
     * @return
     */
    private KTable<Windowed<SensorKeyDTO>, SensorAggregateMetricsDTO> buildAggregateMetricsBySensor(KStream<SensorKeyDTO, SensorDataDTO> stream) {
        return stream
                .groupByKey()
                .windowedBy(TimeWindows.of(Duration.ofMinutes(WINDOW_TIME_IN_MINUTES)))
                .aggregate(() -> new SensorAggregateMetricsDTO(), // initializer
                        (key, value, aggregate) -> {

                            final SensorAggregateMetricsDTO aggregateMetricsDTO = new SensorAggregateMetricsDTO();

                            logger.debug("Aggregate Called for Sensor name -> " + value.getName());
                            logger.debug("Aggregate Count Measures-> " + aggregate.getCountMeasures());
                            logger.debug("Aggregate Avg Temperature -> " + aggregate.getAvgTemperature());
                            logger.debug("Aggregate Avg Humidity -> " + aggregate.getAvgHumidity());
                            logger.debug("Aggregate Avg Luminosity -> " + aggregate.getAvgLuminosity());
                            logger.debug("Aggregate Avg Pressure -> " + aggregate.getAvgPressure());

                            aggregateMetricsDTO.setId(value.getId());
                            aggregateMetricsDTO.setName(value.getName());
                            aggregateMetricsDTO.setCountMeasures(aggregate.getCountMeasures() + 1);
                            // Temperature
                            aggregateMetricsDTO.setSumTemperature(aggregate.getSumTemperature() + value.getPayload().getTemperature());
                            aggregateMetricsDTO.setAvgTemperature(aggregateMetricsDTO.getSumTemperature() / aggregateMetricsDTO.getCountMeasures());
                            // Humidity
                            aggregateMetricsDTO.setSumHumidity(aggregate.getSumHumidity() + value.getPayload().getHumidity());
                            aggregateMetricsDTO.setAvgHumidity(aggregateMetricsDTO.getSumHumidity() / aggregateMetricsDTO.getCountMeasures());
                            // Luminosity
                            aggregateMetricsDTO.setSumLuminosity(aggregate.getSumLuminosity() + value.getPayload().getLuminosity());
                            aggregateMetricsDTO.setAvgLuminosity(aggregateMetricsDTO.getSumLuminosity() / aggregateMetricsDTO.getCountMeasures());
                            // Pressure
                            aggregateMetricsDTO.setSumPressure(aggregate.getSumPressure() + value.getPayload().getPressure());
                            aggregateMetricsDTO.setAvgPressure(aggregateMetricsDTO.getSumPressure() / aggregateMetricsDTO.getCountMeasures());
                            return aggregateMetricsDTO;
                        },
                        Materialized
                                .with(new SensorKeySerde(), new SensorAggregateMetricsSerde()));
    }

}
