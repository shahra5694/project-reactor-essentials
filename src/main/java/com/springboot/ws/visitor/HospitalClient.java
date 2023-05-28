package com.springboot.ws.visitor;

import java.util.List;

/*
* A design pattern that helps to add new behaviour to an entity without changing its structure
* */
public class HospitalClient {

    public static void main(String[] args) {
        Patient patient = new Patient("Mohan");
        Physician physicianVisitor = new Physician();
        patient.attend(physicianVisitor);

        System.out.println("-----------------------");

        List<IPatientVisitor> iPatientVisitors = List.of(new Physician(), new Dentist(), new Nurse());
        iPatientVisitors.forEach(visitor -> patient.attend(visitor));
    }
}
