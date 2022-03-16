package model;

public class Player {

    // Eigenschaften
    private int x;
    private int y;
    private int h;
    private int w;

    // Konstruktoren
    public Player() {
        this.x = 450;
        this.y = 750;
        this.h = 30;
        this.w = 30;
    }

    // Methoden
    public void move (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public void restart(){
        this.x = 450;
        this.y = 750;
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

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }
}
