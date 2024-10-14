package com.springboot.ws.structuraldesignpatterns.adapter;

public class WallSocketImpl implements WallSocket {

    @Override
    public Volt getVolts() {
        return new Volt(240);
    }
}
