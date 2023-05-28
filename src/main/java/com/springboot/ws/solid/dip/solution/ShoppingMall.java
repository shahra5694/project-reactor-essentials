package com.springboot.ws.solid.dip.solution;

public class ShoppingMall {

    private BankCard bankCard;

    public ShoppingMall(BankCard bankCard){
        this.bankCard=bankCard;
    }

    public void doPurchase(long amount) {
        bankCard.doTxn(amount);
    }

    public static void main(String[] args) {
        BankCard bankCard1 = new DebitCard();
        ShoppingMall shoppingMall = new ShoppingMall(bankCard1);
        shoppingMall.doPurchase(5000);
    }
}
