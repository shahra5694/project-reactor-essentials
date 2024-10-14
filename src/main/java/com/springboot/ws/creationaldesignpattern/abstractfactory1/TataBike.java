package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class TataBike implements Bike {

    @Override
    public void showColor(String color) {
        System.out.println("Tata Bike created with "+color);
    }
}
