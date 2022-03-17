package model;

import java.awt.*;

public class Car {

    // Eigenschaften
    private int x;
    private int y;
    private int h;
    private int w;
    private float speedX;

    // Konstruktoren
    public Car(int x, int y, float speedX) {
        this.x = x;
        this.y = y;
        this.h = 40;
        this.w = 100;
        this.speedX = speedX;
    }

    // Methoden
    public void update(long elapsedTime){
        this.x = Math.round(this.x + elapsedTime*speedX);
    }

    // Setter + Getter
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    public float getSpeedX() {
        return speedX;
    }
}
