package model;

public class Player {

    // Eigenschaften
    private int x;
    private int y;
    private int h;
    private int w;

    // Konstruktoren
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.h = 30;
        this.w = 30;
    }

    // Methoden
    public void move (int dx, int dy) {
        this.x += dx;
        this.y += dy;
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

}
