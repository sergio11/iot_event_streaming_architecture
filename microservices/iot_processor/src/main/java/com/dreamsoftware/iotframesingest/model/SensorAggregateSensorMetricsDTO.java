package com.dreamsoftware.iotframesingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorAggregateSensorMetricsDTO implements Serializable {

    @JsonProperty("sensor_id")
    private String id;

    @JsonProperty("sensor_name")
    private String name;

    @JsonProperty("start_agg")
    private Date startAgg;

    @JsonProperty("start_agg_tm")
    private long startAggTm;

    @JsonProperty("end_agg")
    private Date endAgg;

    @JsonProperty("end_agg_tm")
    private long endAggTm;

    @JsonProperty("count_measures")
    private int countMeasures;

    @JsonProperty("sum_temperature")
    private int sumTemperature;

    @JsonProperty("sum_humidity")
    private int sumHumidity;

    @JsonProperty("sum_pressure")
    private int sumPressure;

    @JsonProperty("sum_luminosity")
    private int sumLuminosity;

    @JsonProperty("avg_temperature")
    private float avgTemperature;

    @JsonProperty("avg_humidity")
    private int avgHumidity;

    @JsonProperty("avg_pressure")
    private int avgPressure;

    @JsonProperty("avg_luminosity")
    private int avgLuminosity;

}
