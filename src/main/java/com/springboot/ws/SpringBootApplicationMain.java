package com.springboot.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringBootApplicationMain {

    public static Logger logger = LoggerFactory.getLogger(SpringBootApplicationMain.class);

    @PostConstruct
    public void init() {
        logger.info("this is init method");
    }

    public static void main(String [] ar) {
        logger.info("Application execution started");
        SpringApplication.run(SpringBootApplicationMain.class);
    }
}
