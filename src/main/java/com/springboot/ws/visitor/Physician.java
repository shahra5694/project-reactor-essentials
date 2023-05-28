package com.springboot.ws.visitor;

public class Physician implements IPatientVisitor {
    @Override
    public void visit(Patient patient) {
        // perform checkup
    }
}
