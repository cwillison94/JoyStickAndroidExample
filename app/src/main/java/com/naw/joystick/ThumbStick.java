package com.naw.joystick;

/**
 * Created by fs on 2015-03-15.
 */
public class ThumbStick {

    public static final int RADIUS = 100;
    private int x;
    private int y;

    private int width;
    private int height;

    private int translationalX;
    private int translationalY;

    private boolean isFocused = false;


    public ThumbStick(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;

        this.width = width;
        this.height = height;

        this.translationalX = width / 2;
        this.translationalY = height / 2;
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

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getTranslationalCoords() {
        int[] temp = {x - width / 2, y - height / 2};
        return temp;
    }

    public int getTranslationalX() {
        return (x - width / 2);
    }

    public int getTranslationalY() {
        return (y - height / 2);
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setFocused(boolean isFocused) {
        this.isFocused = isFocused;
    }

    public boolean isTouched(int xTouch, int yTouch) {
       return ((x - xTouch) * (x - xTouch) + (y - yTouch) * (y - yTouch) <= RADIUS * RADIUS);
    }

    public boolean isInBound(int a, int b, int r) {
        return (((x-a)*(x-a) + (y-b)*(y-b)) <= (r+RADIUS)*(r+RADIUS));
    }
}
