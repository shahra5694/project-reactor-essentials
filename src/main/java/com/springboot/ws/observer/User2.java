package com.springboot.ws.observer;

public class User2 implements Observer {
    @Override
    public void update(String msg) {
        System.out.println("user 2 :"+msg);
    }
}
