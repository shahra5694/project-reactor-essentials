package com.springboot.ws.solid.ocp;

public interface NotificationService {
    public void sendOTP(String medium);
    public void sendTxnReport(String medium);
}
