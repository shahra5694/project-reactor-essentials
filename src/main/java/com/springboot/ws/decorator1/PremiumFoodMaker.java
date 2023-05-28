package com.springboot.ws.decorator1;

public class PremiumFoodMaker implements IFoodMaker {

    @Override
    public Food prepare(String type) {
        System.out.println("Premium Food prepared: "+type);
        // gather ingredients
        //prepare food
        // return food
        return new Food();
    }
}
