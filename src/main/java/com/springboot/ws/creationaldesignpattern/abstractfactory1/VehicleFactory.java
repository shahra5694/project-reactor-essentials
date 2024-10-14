package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class VehicleFactory {

    public static VehicleAbstractFactory createFactory(String factory) {
        return factory.equals("TATA") ? new TataFactory() : new TeslaFactory();
    }
}
