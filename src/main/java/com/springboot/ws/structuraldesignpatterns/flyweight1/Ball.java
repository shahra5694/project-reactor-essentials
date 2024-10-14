package com.springboot.ws.structuraldesignpatterns.flyweight1;

public class Ball {
    private String color;
    private String imageUrl;
    private int coordX;
    private int coordY;
    private int radius;

    public Ball(String color, String imageUrl) {
        this.color = color;
        this.imageUrl = imageUrl;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void draw(){
        System.out.println("Ball Drawn with color " + color);
    }
}
