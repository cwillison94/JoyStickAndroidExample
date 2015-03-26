package com.naw.joystick;

/**
 * Created by fs on 2015-03-16.
 */
public class ThumbStickV2 extends MyCircle {

    private int width;
    private int height;

    private boolean isFocused = false;

    public ThumbStickV2(int x, int y, int radius, int screenWidth, int screenHeight) {
        super(x, y, radius);
        this.width = screenWidth;
        this.height = screenHeight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFocused() {
        return isFocused;
    }

    public void setFocused(boolean isFocused) {
        this.isFocused = isFocused;
    }

    public int[] getTranslational() {
        int[] temp = {getX() - width / 2, getY() - height / 2};
        return temp;
    }

    public int getTranslationalX() {
        return (getX() - width / 2);
    }

    public int getTranslationalY() {
        return (getY() - height / 2);
    }

    public boolean isTouched(int xTouch, int yTouch) {
        return ((getX() - xTouch) * (getX() - xTouch) + (getY() - yTouch) * (getY() - yTouch) <= getRadius() * getRadius());
    }

}
