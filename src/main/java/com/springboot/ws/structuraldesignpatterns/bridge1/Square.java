package com.springboot.ws.structuraldesignpatterns.bridge1;

public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn with "+ color.fill();
    }
}
