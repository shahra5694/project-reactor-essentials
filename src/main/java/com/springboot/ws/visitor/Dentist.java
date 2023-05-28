package com.springboot.ws.visitor;

public class Dentist implements IPatientVisitor {
    @Override
    public void visit(Patient patient) {
        // perform checkup by dentist
    }
}
