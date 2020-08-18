package com.udaan.plms.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/plms/ping")
    public String ping() {
        return "pong";
    }
}
