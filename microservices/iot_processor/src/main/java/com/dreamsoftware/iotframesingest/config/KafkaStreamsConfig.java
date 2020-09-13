package com.dreamsoftware.iotframesingest.config;

import com.dreamsoftware.iotframesingest.model.SensorDataDTO;
import com.dreamsoftware.iotframesingest.model.SensorKeyDTO;
import com.dreamsoftware.iotframesingest.processor.AggregateMetricsBySensorProcessor;
import com.dreamsoftware.iotframesingest.processor.AggregateMetricsByPlaceProcessor;
import com.dreamsoftware.iotframesingest.processor.MetricsTimeSeriesProcessor;
import com.dreamsoftware.iotframesingest.serde.SensorDataSerde;
import com.dreamsoftware.iotframesingest.serde.SensorKeySerde;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndContinueExceptionHandler;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

/**
 *
 * @author ssanchez
 */
@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaStreamsConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaStreamsConfig.class);

    @Value("${kafka.topic.input}")
    private String inputTopic;

    /**
     * Aggregate Metrics By Sensor Processor
     */
    @Autowired
    private AggregateMetricsBySensorProcessor aggregateMetricsBySensorProcessor;

    /**
     * Aggregate Metrics By Place Processor
     */
    @Autowired
    private AggregateMetricsByPlaceProcessor aggregateMetricsByPlaceProcessor;

    /**
     * Metrics Time Series Processor
     */
    @Autowired
    private MetricsTimeSeriesProcessor metricsTimeSeriesProcessor;

    /**
     * Provide KStreams Configs
     *
     * @param kafkaProperties
     * @return
     */
    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration provideKStreamsConfigs(final KafkaProperties kafkaProperties) {
        Map<String, Object> config = new HashMap<>();
        config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        config.put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaProperties.getClientId());
        config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, SensorKeySerde.class.getName());
        config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SensorDataSerde.class.getName());
        config.put(StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, LogAndContinueExceptionHandler.class);
        return new KafkaStreamsConfiguration(config);
    }

    /**
     * Provide KStream
     *
     * @param kStreamBuilder
     * @return
     */
    @Bean
    public KStream<SensorKeyDTO, SensorDataDTO> provideKStream(StreamsBuilder kStreamBuilder) {
        final KStream<SensorKeyDTO, SensorDataDTO> stream = kStreamBuilder.stream(inputTopic);
        logger.debug("Start Aggregate Metrics By Sensor Processor Stream");
        aggregateMetricsBySensorProcessor.process(stream);
        logger.debug("Start Aggregate Metrics By Place Processor Stream");
        aggregateMetricsByPlaceProcessor.process(stream);
        logger.debug("Metrics Time Series Processor Stream");
        metricsTimeSeriesProcessor.process(stream);
        return stream;
    }

}
