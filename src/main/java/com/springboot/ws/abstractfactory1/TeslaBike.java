package com.springboot.ws.abstractfactory1;

public class TeslaBike implements Bike {
    @Override
    public void showColor(String color) {
        System.out.println("Tesla Bike created with "+color);
    }
}
