package com.springboot.ws.visitor;

public class Patient {

    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public void attend(IPatientVisitor visitor){
        visitor.visit(this);
    }
}
