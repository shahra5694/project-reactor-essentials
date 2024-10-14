package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class TeslaCar implements Car {

    @Override
    public void showColor(String color) {
        System.out.println("Tesla Car created with " +color);
    }
}
