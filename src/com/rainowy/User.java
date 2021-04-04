package com.rainowy;

public class User {

    private String name;
    private double points;

    public User(String name, double points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }
}
