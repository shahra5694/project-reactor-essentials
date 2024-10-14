package com.springboot.ws.structuraldesignpatterns.decorator1;

public class VoiceFoodMaker implements IFoodMaker {

    protected IFoodMaker foodMaker;

    public VoiceFoodMaker(IFoodMaker foodMaker) {
        this.foodMaker = foodMaker;
    }

    @Override
    public Food prepare(String type) {
        Food f = this.foodMaker.prepare(type);
        playSound();
        return f;
    }

    private void playSound(){
        System.out.println("Play sound");
    }
}
