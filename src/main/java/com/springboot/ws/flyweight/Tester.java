package com.springboot.ws.flyweight;

public class Tester implements Employee {

    private final String JOB;

    private String skill;

    public Tester() {
        JOB = "Test issue";
    }

    @Override
    public void addSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public void task() {
        System.out.println("Tester with Skill: " + this.skill + " with Job: " + JOB);
    }
}
