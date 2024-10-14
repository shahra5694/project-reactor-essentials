package com.springboot.ws.behavioraldesignpatterns.chainofresponsibility;

public class InterviewPanel {
    private Round firstRound;

    public InterviewPanel() {
        Round technicalRound = new TechnicalRound();
        Round managerRound = new ManagerRound();
        Round hrRound = new HrRound();

        this.firstRound = technicalRound;
        technicalRound.set_next(managerRound);
        managerRound.set_next(hrRound);
    }

    public boolean start(Candidate candidate) {
        return firstRound.hire(candidate);
    }
}
