package com.springboot.ws.structuraldesignpatterns.adapter;

public class ClientTest {

    public static void main(String[] args) {
        WallSocket wallSocket = new WallSocketImpl();
        System.out.println(wallSocket.getVolts());

        MobileAdapter mobileAdapter = new MobileAdapterImpl(wallSocket);
        Volt v3 = mobileAdapter.get3Volt();
        System.out.println(v3);
    }
}
