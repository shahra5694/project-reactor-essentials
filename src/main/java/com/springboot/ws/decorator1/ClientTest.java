package com.springboot.ws.decorator1;

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
