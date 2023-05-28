package com.springboot.ws.flyweight1;

import java.util.HashMap;
import java.util.Map;

public class BallFactory {

    private static final Map ballMap = new HashMap<>();

    public static Ball getBall(String color, String url) {
        StringBuilder builder = new StringBuilder();
        String ballCache = builder.append(color).append(url).toString();
        Ball ball = (Ball)ballMap.get(ballCache);
        if(ball == null) {
            ball = new Ball(color,url);
            ballMap.put(ballCache,ball);
            System.out.println("creating ball of color "+color);
        }
        return ball;
    }
}
