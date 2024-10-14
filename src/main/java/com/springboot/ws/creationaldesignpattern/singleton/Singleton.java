package com.springboot.ws.creationaldesignpattern.singleton;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            //synchronized block to remove overhead
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    protected Object clone() throws CloneNotSupportedException
    {
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}
