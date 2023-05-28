package com.springboot.ws.controller;

import com.springboot.ws.gcppubsub.DemoPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/app")
public class ExampleController {

    @Autowired
    private DemoPublisher demoPublisher;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    @PostMapping(value = "/publish", produces = "application/json")
    public ResponseEntity<Void> publishMessage(@RequestBody Map<String,Object> data) throws Exception {
        demoPublisher.publishMessage(data);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
