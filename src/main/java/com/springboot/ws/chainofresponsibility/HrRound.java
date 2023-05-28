package com.springboot.ws.chainofresponsibility;

public class HrRound extends Round {
    @Override
    public boolean hire(Candidate candidate) {
        int score = 80;
        if (score > 70 && _next != null)
            _next.hire(candidate);
        else if (score > 70)
            return true;
        return false;
    }
}
