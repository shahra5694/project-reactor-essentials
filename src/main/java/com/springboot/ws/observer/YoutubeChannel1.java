package com.springboot.ws.observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel1 implements Subject{

    List<Observer> observerList ;

    public YoutubeChannel1() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void unRegisterObserver(Observer o) {
        int index = this.observerList.indexOf(o);
        if (index>0)
            this.observerList.remove(index);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer observer: this.observerList) {
            observer.update(msg);
        }
    }

    void newVideoAdded(String msg) {
        notifyObserver(msg);
    }
}
