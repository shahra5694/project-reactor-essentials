package com.springboot.ws.structuraldesignpatterns.decorater;

public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.println(" adding feature of basic car");
    }
}
