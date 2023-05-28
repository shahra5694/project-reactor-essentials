package com.springboot.ws.bridge1;

public class Main {

    public static void main(String[] args) {
        Shape square = new Square(new Blue());
        System.out.println(square.draw());

        Shape rectangle = new Rectangle(new Red());
        System.out.println(rectangle.draw());
    }
}
