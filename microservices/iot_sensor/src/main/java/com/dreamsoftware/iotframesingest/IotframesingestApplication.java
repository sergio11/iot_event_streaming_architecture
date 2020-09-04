package com.dreamsoftware.iotframesingest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IotframesingestApplication {

    public static void main(String[] args) {
        SpringApplication.run(IotframesingestApplication.class, args);
    }

}
