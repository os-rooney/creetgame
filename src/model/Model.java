package model;

import java.util.LinkedList;
import java.util.List;

public class Model {

    // FINALS
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 900;

    // Eigenschaften
    private List<Car> cars = new LinkedList<>();
    private Player player;

    // Konstruktoren
    public Model() {
        for(int i = -1000; i < 10000; i+=10){
            this.cars.add(new Car(-i*85, 355, -0.4f));
            this.cars.add(new Car(i*65, 460, 0.5f));
            this.cars.add(new Car(-i*55, 565, -0.3f));
            this.cars.add(new Car(i*35, 670, 0.1f));
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
    public void checkCollision(){
        boolean collided = false;
        for (Car car: cars) {
            if(player.getX() >= car.getX() &&
                    (player.getX() + player.getW()) <=  (car.getX() + car.getW())){

                    if(player.getY() <= car.getY() && (player.getY() + player.getH()) <= (car.getY() + car.getH())){
                        collided = true;
                    }
            }
        }
        System.out.println(collided + " collision?");
    }


    // Setter + Getter
    public List<Car> getCars() {
        return cars;
    }

    public Player getPlayer() {
        return player;
    }
}
