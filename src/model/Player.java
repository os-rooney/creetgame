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
    // return the player to the start point
    public void restart(){
        this.x = 450;
        this.y = 750;
    }

    // Check if the player is inside the game area - X axis
    public void checkPlayerPositionX(){
        if(this.getX() >= 1000){
            this.setX(985);
        } else if(this.getX() <= 0){
            this.setX(15);
        }
    }

    // Check if the player is inside the game area - Y axis
    public void checkPlayerPositionY(){
        if(this.getY() >= 900){
            this.setY(885);
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
