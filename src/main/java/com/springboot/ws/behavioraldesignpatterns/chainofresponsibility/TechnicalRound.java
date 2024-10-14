package com.springboot.ws.behavioraldesignpatterns.chainofresponsibility;

public class TechnicalRound extends Round {
    @Override
    public boolean hire(Candidate candidate) {
        int score = 80;

        if (score > 70 && _next != null)
            return _next.hire(candidate);
        return false;
    }
}
