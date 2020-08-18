package com.udaan.plms.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {
    private final String number;
    private final Type type;

    @JsonCreator
    public Vehicle(@JsonProperty String number, @JsonProperty Type type) {
        this.number = number;
        this.type = type;
    }

    public enum Type {
        TwoWheeler, Hatchback, Sedan, SUV, XUV
    }

    public String getNumber() {
        return number;
    }

    public Type getType() {
        return type;
    }
}
