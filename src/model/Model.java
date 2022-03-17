package model;

import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    // FINALS
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 900;

    // Eigenschaften
    private List<Car> cars = new ArrayList<Car>();
    private Player player;

    // Konstruktoren
    public Model() {
        for(int i = -1000; i < 10000; i+=10){
            //this.cars.add(new Car(-i*85, 355, 0.1f));
            //this.cars.add(new Car(i*65, 460, 0.1f));
            //this.cars.add(new Car(-i*55, 565, -0.1f));
            this.cars.add(new Car(i * 35, 670, 0.1f));
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
        /*for (Car car: cars) {
            if(player.getX() >= car.getX() &&
                    (player.getX() + player.getW()) <=  (car.getX() + car.getW())){

                    if(player.getY() >= car.getY() &&
                            (player.getY() + player.getH()) <= (car.getY() + car.getH())){
                        collided = true;
                        accident();
                    }
            }
        }*/
        for (Car car: cars) {
            if(player.getX() >= car.getX() &&
                    (player.getX() + player.getW()) <=  (car.getX() + car.getW())){

                if(player.getY() >= car.getY() &&
                        (player.getY() + player.getH()) <= (car.getY() + car.getH())){
                    collided = true;
                    accident();
                }
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
        System.out.println(getPlayer().getX());
    }

    // check if player is beneath the car (no collision)
    // check if the top left point of the player is beneath the right bottom point of the Car
    //public boolean checkIfPlayerBeneathCar(){    }

    // Setter + Getter
    public List<Car> getCars() {
        return cars;
    }

    public Player getPlayer() {
        return player;
    }
}
