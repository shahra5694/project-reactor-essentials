package com.springboot.ws.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Override
    public Flux<Customer> getCustomers() {
        return Flux.range(0,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count "+i))
                .map(i -> new Customer(i,"customer"+i));
    }
}
