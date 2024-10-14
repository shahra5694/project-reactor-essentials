package com.springboot.ws.creationaldesignpattern.singleton;

import java.lang.reflect.Constructor;

public class ReflectionToBreakSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = null;

        try {
            Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();

            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                s2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("S1=" + s1.hashCode());
        System.out.println("S2=" + s2.hashCode());
    }
}
