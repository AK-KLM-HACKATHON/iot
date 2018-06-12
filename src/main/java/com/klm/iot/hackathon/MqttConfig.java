package com.klm.iot.hackathon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;

/**
 * Created by klm75203 on 7/10/2017.
 */
//@Configuration
public class MqttConfig {

    @Bean
    public MessageChannel mqttChannel() {
        return new DirectChannel();
    }

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs("tcp://liveobjects.orange-business.com:1883");
        factory.setUserName("json+bridge");
        factory.setPassword("d54ad2639ec8488983274f0e8b77fd24");
        factory.setCleanSession(false);//to make durable subscription
        return factory;
    }

    @Bean
    public MessageEventAdapter mqttMessageSubscriber() {
        MessageEventAdapter adapter =
                new MessageEventAdapter("event-client", mqttClientFactory(), "fifo/hackathon-queue-kit-6");
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(0);
        adapter.setOutputChannel(mqttChannel());
        adapter.setTaskScheduler(new DefaultManagedTaskScheduler());
        adapter.setRecoveryInterval(60000);
        return adapter;
    }

}
