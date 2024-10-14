package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class TeslaBike implements Bike {
    @Override
    public void showColor(String color) {
        System.out.println("Tesla Bike created with "+color);
    }
}
