/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamsoftware.iotframesingest.config;

import java.util.UUID;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ssanchez
 */
@Configuration
public class MQTTConfig {

    /**
     * Provide MQTT Connect Options
     *
     * @return
     */
    @Bean
    public MqttConnectOptions provideMqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        return options;
    }

    /**
     * Provide MQTT Client
     *
     * @param mqttServerUrl
     * @param connectOptions
     * @return
     * @throws MqttException
     */
    @Bean
    public IMqttClient provideMqttClient(
            @Value("${mqtt.server.url}") String mqttServerUrl,
            MqttConnectOptions connectOptions) throws MqttException {
        String publisherId = UUID.randomUUID().toString();
        IMqttClient client = new MqttClient(mqttServerUrl, publisherId);
        client.connect(connectOptions);
        return client;
    }
}
