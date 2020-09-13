package com.dreamsoftware.iotframesingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Sensor Time Serie Metric
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorTimeSerieMetricDTO implements Serializable {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("dimensions")
    private SensorTimeSerieMetricDimensionsDTO dimensions;

    @JsonProperty("values")
    private SensorTimeSerieMetricValuesDTO values;

}
