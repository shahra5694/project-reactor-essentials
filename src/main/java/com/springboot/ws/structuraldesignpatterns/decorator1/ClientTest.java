package com.springboot.ws.structuraldesignpatterns.decorator1;


/**
 * Decorator design pattern is one of the structural design pattern. it is used to modify the functionality of an object
 * at runtime and at the same time, other instances of same class will be not be affected by this. it uses the abstract class
 * or interface with composition to implement it
 */
public class ClientTest {

    public static void main(String[] args) {

//        Client A
        IFoodMaker foodMaker = new FoodMaker();
        foodMaker.prepare("fast food");

        System.out.println("---------------------------");

//        Client B
        IFoodMaker voiceFoodMaker = new VoiceFoodMaker(new FoodMaker());
        voiceFoodMaker.prepare("fast food");

        System.out.println("---------------------------");

//        Client C

        IFoodMaker premiumFoodMaker = new VoiceFoodMaker(new PremiumFoodMaker());
        premiumFoodMaker.prepare("fast food");
    }
}
