package com.springboot.ws.controller;

import com.springboot.ws.service.Customer;
import com.springboot.ws.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customer")
public class EventDrivenController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping
    @RequestMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomers() {
        return iCustomerService.getCustomers();
    }
}
