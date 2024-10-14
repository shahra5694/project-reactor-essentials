package com.springboot.ws.structuraldesignpatterns.flyweight;

import java.util.Random;

public class Engineering {

    private static String employeeType[] = {"Developer", "Tester"};
    private static String skills[] = {"Java", "C++", ".Net", "Python"};

    public static void main(String[] args) {
        for(int i=0; i<10; i++) {
            Employee employee = EmployeeFactory.getEmployee(getRandEmployee());
            employee.addSkill(getRandSkill());
            employee.task();
        }
    }

    public static String getRandEmployee() {
        Random r = new Random();
        int i = r.nextInt(employeeType.length);
        return employeeType[i];
    }
    public static String getRandSkill() {
        Random r = new Random();
        int i = r.nextInt(skills.length);
        return skills[i];
    }
}
