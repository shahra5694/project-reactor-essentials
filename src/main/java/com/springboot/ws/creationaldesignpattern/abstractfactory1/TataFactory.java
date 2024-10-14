package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class TataFactory implements VehicleAbstractFactory {

    @Override
    public Car getCar() {
        return new TataCar();
    }

    @Override
    public Bike getBike() {
        return new TataBike();
    }
}
