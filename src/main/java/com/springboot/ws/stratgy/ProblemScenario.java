package com.springboot.ws.stratgy;

/*
 *  This is behavioural design pattern which allows to change the behaviour of a program based on selected strategy.
 * */

public class ProblemScenario {
    public void render(String choice, String Data) {
        if(choice.equals("barchart") ) {
            // code logic to render bar chart
        }
        else if(choice.equals("piechart")) {
            // code logic to render the pie chart
        }
        else {
            // other chart
        }
    }
}
