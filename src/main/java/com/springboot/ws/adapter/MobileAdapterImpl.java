package com.springboot.ws.adapter;

public class MobileAdapterImpl implements MobileAdapter {

    private WallSocket wallSocket;

    public MobileAdapterImpl(WallSocket wallSocket) {
        this.wallSocket = wallSocket;
    }

    @Override
    public Volt get3Volt() {
       Volt v240 = wallSocket.getVolts();
       return new Volt(v240.getVolt()/80);
    }
}
