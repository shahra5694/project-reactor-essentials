package com.springboot.ws.solid.ocp;

public class EmailNotificationService implements NotificationService {

    @Override
    public void sendOTP(String medium) {
        // write logic to integrate with email api
    }

    @Override
    public void sendTxnReport(String medium) {
        // write logic to integrate with email api
    }
}
