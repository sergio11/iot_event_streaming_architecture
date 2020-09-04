package com.dreamsoftware.iotframesingest.tasks;

import com.dreamsoftware.iotframesingest.sensor.IoTSensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author ssanchez
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    protected IoTSensor temperatureSensor;

    /**
     * Report Current Temperature every scond Task
     */
    @Scheduled(fixedRate = 1000)
    public void reportCurrentTemperature() {
        logger.debug("Report Current Temperature");
        try {
            temperatureSensor.call();
        } catch (Exception ex) {
            ex.printStackTrace();
            logger.debug("Error Ocurred -> " + ex.getMessage());
        }
    }
}
