package com.udaan.plms.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Success<T> extends Response<T> {

    @JsonCreator
    public Success(@JsonProperty T data) {
        super(data, Status.Success);
    }
}
