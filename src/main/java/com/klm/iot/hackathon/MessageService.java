package com.klm.iot.hackathon;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    int noiseLevel;

    public void setNoiseLevel(int noiseLevel){
            this.noiseLevel = noiseLevel;
    }

    public int getData(){
        return noiseLevel;
    }

}
