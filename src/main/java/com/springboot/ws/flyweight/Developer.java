package com.springboot.ws.flyweight;

public class Developer implements Employee {

    private final String JOB;
    private String skill;

    public Developer() {
        JOB = "Fix issue";
    }

    @Override
    public void addSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Developer with skill: " + this.skill + " with Job: " + JOB);
    }
}
