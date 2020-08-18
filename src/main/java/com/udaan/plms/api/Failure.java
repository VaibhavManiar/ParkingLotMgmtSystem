package com.udaan.plms.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Failure extends Response<String> {
    private final Error error;

    @JsonCreator
    public Failure(@JsonProperty Error error) {
        super("", Status.Failure);
        this.error = error;
    }

    public static class Error {
        private final String message;

        public Error(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public Error getError() {
        return error;
    }
}
