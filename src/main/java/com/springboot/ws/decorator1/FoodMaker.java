package com.springboot.ws.decorator1;

public class FoodMaker implements IFoodMaker {

    @Override
    public Food prepare(String type) {
        System.out.println("Normal Food prepared: "+type);
        // gather ingredients
        //prepare food
        // return food
        return new Food();
    }
}
