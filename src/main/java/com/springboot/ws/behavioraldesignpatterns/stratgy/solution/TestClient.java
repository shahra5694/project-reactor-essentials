package com.springboot.ws.behavioraldesignpatterns.stratgy.solution;

public class TestClient {

    public static void main(String[] args) {
       IRenderer renderer = Factory.getRender("bar");
       renderer.render("chart data");
    }
}
