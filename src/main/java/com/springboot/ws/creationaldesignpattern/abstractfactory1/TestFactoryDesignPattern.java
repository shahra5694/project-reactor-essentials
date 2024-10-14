package com.springboot.ws.creationaldesignpattern.abstractfactory1;

public class TestFactoryDesignPattern {
    public static void main(String ar []) {
        VehicleAbstractFactory factory = VehicleFactory.createFactory("TATA");
        factory.getBike().showColor("RED Color");
        factory.getCar().showColor("BLACK Color");

        VehicleAbstractFactory tesla = VehicleFactory.createFactory("TESLA");
        tesla.getCar().showColor("WHITE Color");
        tesla.getBike().showColor("YELLOW Color");
    }
}
