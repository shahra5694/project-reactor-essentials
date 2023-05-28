package com.springboot.ws.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class MyConfiguration {

//    @Bean
//    @Scope(value = "singleton")
//    public MyBean myBean() {
//        return new MyBean();
//    }

//    @Bean
//    @Scope(value = "prototype")
//    public MyBean myBean() {
//        return new MyBean();
//    }

    @Bean
    @Scope(value = "request")
    public MyBean myBean() {
        return new MyBean();
    }
}
