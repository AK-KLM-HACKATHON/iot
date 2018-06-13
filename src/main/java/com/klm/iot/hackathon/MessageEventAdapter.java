package com.klm.iot.hackathon;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;

import java.util.Random;

/**
 * Created by klm75203 on 4/24/2017.
 */

public class MessageEventAdapter extends MqttPahoMessageDrivenChannelAdapter {

    @Autowired
    MessageService messageService;


    public MessageEventAdapter(final String clientId, final MqttPahoClientFactory clientFactory, final String... topics) {
        super(clientId, clientFactory, topics);
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Soundlevel soundlevel = gson.fromJson(new String(mqttMessage.getPayload()), Soundlevel.class);
            int soundDecibel = Integer.valueOf(soundlevel.getValue().getSoundlevel());
            System.out.println("Hurray received the message with decible level: "+soundDecibel);
            messageService.setNoiseLevel(soundDecibel);
        } catch (Throwable e) {
            System.out.println(e);
        }
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }
}
