package com.klm.iot.hackathon;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

/**
 * Created by klm75203 on 4/24/2017.
 */

public class MessageEventAdapter extends MqttPahoMessageDrivenChannelAdapter {



    public MessageEventAdapter(final String clientId, final MqttPahoClientFactory clientFactory, final String... topics) {
        super(clientId, clientFactory, topics);
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) {
        try {
            System.out.println("Hurray received the message"+mqttMessage);
           //handle the event
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}
