package com.klm.iot.hackathon;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MessageService {

    public int getData(){
        return new Random().nextInt(100-0) + 0;
    }

}
