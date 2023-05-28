package com.springboot.ws.solid.dip;

public class ShoppingMall {

    private DebitCard debitCard;

    public ShoppingMall(DebitCard debitCard){
        this.debitCard=debitCard;
    }

    public void doPurchase(long amount) {
        debitCard.doTxn(amount);
    }

    public static void main(String[] args) {
        DebitCard debitCard1 = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(debitCard1);
        shoppingMall.doPurchase(5000);
    }
}
