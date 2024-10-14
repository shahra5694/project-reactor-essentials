package com.springboot.ws.structuraldesignpatterns.flyweight1;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Random;

public class FlyweightDemo {
    private static final String[] color = {"Green","Red","Blue"};

    private static final Map<String ,String> map = Map.ofEntries(
            new AbstractMap.SimpleEntry<>("Green","url1"),
            new AbstractMap.SimpleEntry<>("Red","url2"),
            new AbstractMap.SimpleEntry<>("Blue","url3")
    );

    public static void main(String[] args) {
        for(int i=0;i<10;i++) {
            String color = getColor();
            String url = map.get(color);
            Ball ball = BallFactory.getBall(color, url);
            ball.setCoordX(getX());
            ball.setCoordY(getY());
            ball.setRadius(30);
            ball.draw();
            System.out.println(ball.hashCode());
        }
    }

    private static String getColor() {
        Random r = new Random();
        int i = r.nextInt(color.length);
        return color[i];
    }
    private static int getX() {
        return (int)Math.random()*50;
    }
    private static int getY() {
        return (int)Math.random()*40;
    }
}
