package com.springboot.ws.behavioraldesignpatterns.observer;

public interface Subject {
    void registerObserver(Observer o);
    void unRegisterObserver(Observer o);
    void notifyObserver(String msg);
}
