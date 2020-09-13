package com.dreamsoftware.iotframesingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
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
public class SensorTimeSerieMetricDimensionsDTO implements Serializable {

    @JsonProperty("sensor_id")
    private String sensorId;

    @JsonProperty("sensor_name")
    private String sensorName;

    @JsonProperty("place_id")
    private String placeId;

}
