package com.springboot.ws.solid.dip.solution;

/*
 * High-level modules should not depend on low-level modules, both should depend on abstractions.
 * */
public interface BankCard {
    void doTxn(long amount);
}
