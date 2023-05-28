package com.springboot.ws.observer;

public interface Subject {
    void registerObserver(Observer o);
    void unRegisterObserver(Observer o);
    void notifyObserver(String msg);
}
