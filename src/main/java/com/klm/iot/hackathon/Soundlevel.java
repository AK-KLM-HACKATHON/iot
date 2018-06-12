package com.klm.iot.hackathon;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Soundlevel  implements Serializable{


    Value value;
}
