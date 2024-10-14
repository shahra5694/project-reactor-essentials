package com.springboot.ws.behavioraldesignpatterns.chainofresponsibility;

/*
*    This design pattern forms a sequentially connected component and helps consumers
*    to simply pass the object to the first component and then that object gets processed by each component
*    one after another as per sequence defined.
* */
public class Test {

    public static void main(String[] args) {
        Candidate candidate = new Candidate();
        Round technicalRound = new TechnicalRound();
        boolean status = technicalRound.hire(candidate);

        if(!status)
            return;

        Round managerRound = new ManagerRound();
        status = managerRound.hire(candidate);
        if (!status)
            return;

        Round hrRound = new HrRound();
        status = hrRound.hire(candidate);

        if (!status)
            return;

    }
}
