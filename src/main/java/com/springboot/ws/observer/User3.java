package com.springboot.ws.observer;

public class User3 implements Observer {
        @Override
        public void update(String msg) {
            System.out.println("user 3 :"+msg);
        }
}
