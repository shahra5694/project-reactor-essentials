package com.springboot.ws.solid.dip.solution;

public class DebitCard implements BankCard {
    @Override
    public void doTxn(long amount) {
        System.out.println("payment using debit card");
    }
}
