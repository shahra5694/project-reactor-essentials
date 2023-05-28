package com.springboot.ws.chainofresponsibility.solution;

import com.springboot.ws.chainofresponsibility.Candidate;
import com.springboot.ws.chainofresponsibility.InterviewPanel;
import org.checkerframework.checker.units.qual.C;

public class ConsumerClient {

    public static void main(String[] args) {
        InterviewPanel panel = new InterviewPanel();
        boolean hired = panel.start(new Candidate());
    }
}
