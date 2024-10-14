package com.springboot.ws.solid.ocp;

/*
 * Software components should be open for extension, but not for modification.
 * */
public interface NotificationService {
    public void sendOTP(String medium);
    public void sendTxnReport(String medium);
}
