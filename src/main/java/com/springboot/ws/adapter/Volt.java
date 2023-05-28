package com.springboot.ws.adapter;

public class Volt {

    private int volt;

    public Volt(int volt) {
        this.volt = volt;
    }

    public int getVolt() {
        return volt;
    }

   @Override
    public String toString(){
        return "Volt : "+volt;
   }

}
