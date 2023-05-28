package com.springboot.ws.service;

import reactor.core.publisher.Flux;

public interface ICustomerService {

    Flux<Customer> getCustomers();
}
