package com.springboot.ws.solid.isp.solution;

public class GooglePay implements UPIPayments, CashBackManager {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

    @Override
    public void getCashBackAsCreditBalance() {
            // gpay provides this feature
    }
}
