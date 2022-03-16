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
        for(int i = -1000; i < 1000; i+=10){
            this.cars.add(new Car(i*150, 355, 0.7f));
            this.cars.add(new Car(i*100, 460, 0.6f));
            this.cars.add(new Car(i*65, 565, 0.5f));
            this.cars.add(new Car(i*35, 670, 0.3f));
        }

        this.player = new Player(450, 750);
    }

    // Methoden
    public void update (long elapsedTime) {
        for (Car car : cars){
            car.update(elapsedTime);
        }
    }

    public void generateCars(){

    }

    // Setter + Getter
    public List<Car> getCars() {
        return cars;
    }

    public Player getPlayer() {
        return player;
    }
}
