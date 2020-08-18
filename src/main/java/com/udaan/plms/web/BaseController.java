package com.udaan.plms.web;

import com.udaan.plms.api.Failure;
import com.udaan.plms.api.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {

    @ExceptionHandler(Exception.class)
    public Failure handleFailure(Exception e) {
        return new Failure(new Failure.Error(e.getMessage()));
    }
}
