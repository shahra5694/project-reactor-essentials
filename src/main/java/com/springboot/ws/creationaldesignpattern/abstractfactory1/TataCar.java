package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class TataCar implements Car {

    @Override
    public void showColor(String color) {
        System.out.println("Tata Car created with "+ color);
    }
}
