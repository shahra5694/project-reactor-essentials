package com.springboot.ws.solid.isp;


/*
 * No client should be forced to depend on methods that it does not use.
 * */
public interface UPIPayments {
    void payMoney();
    void getScratchCard();
    void getCashBackAsCreditBalance();
}
