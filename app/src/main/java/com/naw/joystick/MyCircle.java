package com.naw.joystick;

/**
 * Created by fs on 2015-03-16.
 */
public class MyCircle {

    private int x;
    private int y;
    private int radius;

    public MyCircle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean checkCollision(MyCircle c) {
        return (((x - c.getX()) * (x - c.getX()) + (y - c.getY()) * (y - c.getY())) <= (radius + c.getRadius()) * (radius + c.getRadius()));
    }
}
