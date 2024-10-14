package com.springboot.ws.behavioraldesignpatterns.chainofresponsibility.solution;

import com.springboot.ws.behavioraldesignpatterns.chainofresponsibility.Candidate;
import com.springboot.ws.behavioraldesignpatterns.chainofresponsibility.InterviewPanel;

public class ConsumerClient {

    public static void main(String[] args) {
        InterviewPanel panel = new InterviewPanel();
        boolean hired = panel.start(new Candidate());
    }
}
