package com.dreamsoftware.iotframesingest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class SensorDataPayloadDTO {

    @JsonProperty("temperature")
    private int temperature;

    @JsonProperty("humidity")
    private int humidity;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("luminosity")
    private int luminosity;

}
