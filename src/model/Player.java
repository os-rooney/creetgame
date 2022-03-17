package model;

import java.awt.*;

public class Player {

    // Eigenschaften
    private int x;
    private int y;
    private int h;
    private int w;

    // Konstruktoren
    public Player() {
        this.x = 470;
        this.y = 650;
        this.h = 30;
        this.w = 30;
    }

    // Methoden
    public void move (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    // return the player to the start point
    public void restart(){
        this.x = 470;
        this.y = 650;
    }

    // end player movement
    public void won(){
        this.y = 140;
    }

    // Check if the player is inside the game area - X axis
    public void checkPlayerPositionX(){
        if(this.getX() >= 970){
            this.setX(970);
        } else if(this.getX() <= 0){
            this.setX(0);
        }
    }

    // Check if the player is inside the game area - Y axis
    public void checkPlayerPositionY(){
        if(this.getY() >= 685){
            this.setY(670);
        } else if(this.getY() <= 0){
            this.setY(15);
        }
    }

    // Getter + Setter
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }
}
