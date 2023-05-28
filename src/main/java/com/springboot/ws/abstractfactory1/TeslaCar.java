package com.springboot.ws.abstractfactory1;

public class TeslaCar implements Car {

    @Override
    public void showColor(String color) {
        System.out.println("Tesla Car created with " +color);
    }
}
