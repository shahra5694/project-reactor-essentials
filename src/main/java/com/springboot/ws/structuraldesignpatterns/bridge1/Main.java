package com.springboot.ws.structuraldesignpatterns.bridge1;

/**
 * Bridge design pattern is one of the Structural design pattern and used to decouple an abstraction
 * from its implementation so that the two(interface/abstract class) can vary independently.
 */
public class Main {

    public static void main(String[] args) {
        Shape square = new Square(new Blue());
        System.out.println(square.draw());

        Shape rectangle = new Rectangle(new Red());
        System.out.println(rectangle.draw());
    }
}
