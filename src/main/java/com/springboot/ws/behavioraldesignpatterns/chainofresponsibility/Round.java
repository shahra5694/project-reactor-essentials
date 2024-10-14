package com.springboot.ws.behavioraldesignpatterns.chainofresponsibility;

public abstract class Round {

    abstract boolean hire(Candidate candidate);

    protected Round _next;

    public void set_next(Round _next) {
        this._next = _next;
    }
}
