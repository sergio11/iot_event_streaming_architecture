package com.dreamsoftware.iotframesingest.processor;

import com.dreamsoftware.iotframesingest.model.SensorAggregateMetricsDTO;
import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import com.dreamsoftware.iotframesingest.serde.SensorAggregateMetricsSerde;
import com.dreamsoftware.iotframesingest.serde.SensorDataSerde;
import java.time.Duration;
import static org.apache.kafka.common.serialization.Serdes.String;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;
import org.apache.kafka.streams.state.Stores;
import org.apache.kafka.streams.state.WindowStore;
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

    private final static int WINDOW_SIZE_IN_MINUTES = 1;
    private final static int RETENTION_IN_HOURS = 6;

    @Value("${kafka.topic.aggregate-metrics}")
    private String outputTopic;

    /**
     *
     * @param stream
     */
    public void process(KStream<SensorKeyDTO, SensorDataDTO> stream) {

        buildAggregateMetricsBySensor(stream)
                .toStream()
                .map((key, value) -> KeyValue.pair(key.key(), value))
                .foreach((key, value) -> {
                    logger.debug("Final Process Key -> " + key);
                    logger.debug("Final Process Count Measures -> " + value.getCountMeasures());
                });
        //.to(outputTopic, Produced.with(String(), new SensorAggregateMetricsSerde()));

    }

    /**
     *
     * @param stream
     * @return
     */
    private KTable<Windowed<String>, SensorAggregateMetricsDTO> buildAggregateMetricsBySensor(KStream<SensorKeyDTO, SensorDataDTO> stream) {
        return stream
                .map((key, val) -> new KeyValue<>(val.getId(), val))
                .groupByKey(Grouped.with(String(), new SensorDataSerde()))
                .windowedBy(TimeWindows.of(Duration.ofMinutes(WINDOW_SIZE_IN_MINUTES)))
                .aggregate(() -> new SensorAggregateMetricsDTO(),
                        (String k, SensorDataDTO v, SensorAggregateMetricsDTO va) -> aggregateData(v, va),
                        buildWindowPersistentStore());
    }

    /**
     * Build Window Persistent Store
     *
     * @return
     */
    private Materialized<String, SensorAggregateMetricsDTO, WindowStore<Bytes, byte[]>> buildWindowPersistentStore() {
        return Materialized.<String, SensorAggregateMetricsDTO>as(
                Stores.persistentWindowStore("aggregate-metrics-by-sensor",
                        Duration.ofHours(RETENTION_IN_HOURS),
                        Duration.ofMinutes(WINDOW_SIZE_IN_MINUTES),
                        false))
                .withKeySerde(String())
                .withValueSerde(new SensorAggregateMetricsSerde());
    }

    /**
     * Aggregate Data
     *
     * @param v
     * @param va
     * @return
     */
    private SensorAggregateMetricsDTO aggregateData(final SensorDataDTO v, final SensorAggregateMetricsDTO va) {
        logger.debug("Aggregate Called for Sensor name -> " + v.getName());
        logger.debug("Aggregate Count Measures-> " + va.getCountMeasures());
        logger.debug("Aggregate Avg Temperature -> " + va.getAvgTemperature());
        logger.debug("Aggregate Avg Humidity -> " + va.getAvgHumidity());
        logger.debug("Aggregate Avg Luminosity -> " + va.getAvgLuminosity());
        logger.debug("Aggregate Avg Pressure -> " + va.getAvgPressure());

        va.setId(va.getId());
        va.setName(va.getName());
        va.setCountMeasures(va.getCountMeasures() + 1);

        // Temperature
        va.setSumTemperature(va.getSumTemperature() + v.getPayload().getTemperature());
        va.setAvgTemperature(va.getSumTemperature() / va.getCountMeasures()); // Humidity

        // Humidity
        va.setSumHumidity(va.getSumHumidity() + v.getPayload().getHumidity());
        va.setAvgHumidity(va.getSumHumidity() / va.getCountMeasures()); // Luminosity

        // Luminosity
        va.setSumLuminosity(va.getSumLuminosity() + v.getPayload().getLuminosity());
        va.setAvgLuminosity(va.getSumLuminosity() / va.getCountMeasures()); // Pressure

        // Pressure
        va.setSumPressure(va.getSumPressure() + v.getPayload().getPressure());
        va.setAvgPressure(va.getSumPressure() / va.getCountMeasures());
        return va;
    }

}
