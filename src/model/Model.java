package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    // FINALS
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    public static boolean START_GAME = false;

    // Eigenschaften
    private List<Car> cars = new ArrayList<Car>();
    private Player player;

    // Konstruktoren
    public Model() {
        for(int i = -10000; i < 800; i+=10){
            int random = (int)(Math.random() * 3)+1;
            this.cars.add(new Car(i*80, 180, -.8f, random));
            this.cars.add(new Car(i*155, 280, -0.5f, random));
            this.cars.add(new Car(i*135, 380, -0.7f,  random));
            this.cars.add(new Car(i*30, 480, 0.1f, random));
            this.cars.add(new Car(i*110, 580, -0.7f, random));
            this.cars.add(new Car(i*65, 680, 0.9f, random));
            this.cars.add(new Car(i*75, 780, 0.6f, random));
        }
        this.player = new Player();
    }



    // Methoden
    public void update (long elapsedTime) {
        for (Car car : cars){
            car.update(elapsedTime);
        }
    }

    // Collision detection
    public boolean checkCollision(){
        boolean collided = false;
        for(Car car : cars){
            if(checkIfCarHitsPlayerFromFront(car, collided)){
                accident();
            }
        }
        return collided;
    }

    // End Game - You Win
    public void youWin(){
        System.out.println("CONGRATULATIONS - YOU WIN");
        getPlayer().restart();
    }

    // accident
    public void accident(){
        System.out.println("Accident");
        getPlayer().restart();

    }

    // check if the car hits the player from font (collision)
    public boolean checkIfCarHitsPlayerFromFront(Car car, boolean collided){
        if((player.getX() >= car.getX() &&
                (player.getX() + player.getW()) <=  (car.getX() + car.getW())) ||
                (player.getX() >= car.getX() &&
                        (player.getX() - player.getW()) <=  (car.getX() - car.getW()))){

            if((player.getY() >= car.getY() &&
                    (player.getY() + player.getH() <= (car.getY() + car.getH()))) ||
                    (player.getY() >= car.getY() &&
                            (player.getY() - player.getH() <= (car.getY() )))){
                collided = true;
            }
        }
        return collided;

    }

    // check driving direction to add the right pic of car and give it a color randomly



    // Setter + Getter
    public List<Car> getCars() {
        return cars;
    }

    public Player getPlayer() {
        return player;
    }
}
