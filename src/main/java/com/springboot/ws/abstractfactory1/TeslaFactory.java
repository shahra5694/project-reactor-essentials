package com.springboot.ws.abstractfactory1;

public class TeslaFactory implements VehicleAbstractFactory {
    @Override
    public Car getCar() {
        return new TeslaCar();
    }

    @Override
    public Bike getBike() {
        return new TeslaBike();
    }
}
