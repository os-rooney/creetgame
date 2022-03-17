package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    // FINALS
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    // Eigenschaften
    private List<Car> cars = new ArrayList<Car>();
    private Player player;

    // Konstruktoren
    public Model() {
        for(int i = -1000; i < 10000; i+=8){
            this.cars.add(new Car(i*65, 225, -0.1f));
            this.cars.add(new Car(i*95, 325, 0.1f));
            this.cars.add(new Car(i*40, 425, -0.1f));
            this.cars.add(new Car(i*35, 525, 0.1f));
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
            if(checkIfCarHitsPlayerFromFrontLeft(car, collided)){
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

    // check if the car hits the player from font on the left side (collision)
    public boolean checkIfCarHitsPlayerFromFrontLeft(Car car, boolean collided){
            if(player.getX() >= car.getX() &&
                    (player.getX() + player.getW()) <=  (car.getX() + car.getW())){

                if(player.getY() >= car.getY() &&
                        (player.getY() + player.getH() <= (car.getY() + car.getH()))){
                    collided = true;
                }
            }
        return collided;
    }

    // Setter + Getter
    public List<Car> getCars() {
        return cars;
    }

    public Player getPlayer() {
        return player;
    }
}
