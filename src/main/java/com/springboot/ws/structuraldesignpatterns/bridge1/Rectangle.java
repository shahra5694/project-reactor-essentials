package com.springboot.ws.structuraldesignpatterns.bridge1;

public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Rectangle drawn with "+ color.fill();
    }
}
