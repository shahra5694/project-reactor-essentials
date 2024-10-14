package com.springboot.ws.behavioraldesignpatterns.observer;

public class User1 implements Observer {

    @Override
    public void update(String msg) {
        System.out.println("user 1 :"+msg);
    }
}
