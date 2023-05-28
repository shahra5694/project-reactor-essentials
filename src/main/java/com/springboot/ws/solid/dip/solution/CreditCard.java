package com.springboot.ws.solid.dip.solution;

public class CreditCard implements BankCard {

    @Override
    public void doTxn(long amount) {
        System.out.println("payment using credit card");
    }
}
