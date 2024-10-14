package com.springboot.ws.structuraldesignpatterns.bridge1;

public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract String draw();
}
