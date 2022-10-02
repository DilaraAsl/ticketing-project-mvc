package com.cydeo.enums;

import lombok.Getter;
import lombok.Setter;


public enum Gender {
    FEMALE("Female"),MALE("Male");
private String value;
    Gender( String value) {
        this.value=value;

    }
    public String getValue(){
        return value;
    }
}
