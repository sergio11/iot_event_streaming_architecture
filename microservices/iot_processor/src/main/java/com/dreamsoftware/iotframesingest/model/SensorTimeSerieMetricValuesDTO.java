package com.dreamsoftware.iotframesingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Sensor Time Serie Metric Values
 *
 * @author ssanchez
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SensorTimeSerieMetricValuesDTO implements Serializable {

    @JsonProperty("temperature")
    private double temperature;

    @JsonProperty("humidity")
    private double humidity;

    @JsonProperty("pressure")
    private double pressure;

    @JsonProperty("luminosity")
    private double luminosity;

}
