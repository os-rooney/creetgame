package model;

import java.util.LinkedList;
import java.util.List;

public class Model {

    // FINALS
    public static final int WIDTH = 1500;
    public static final int HEIGHT = 1000;

    // Eigenschaften
    private List<Car> cars = new LinkedList<>();
    private Player player;

    // Konstruktoren
    public Model() {
        this.cars.add(new Car(40, 20, 0.1f));
        this.cars.add(new Car(40, 80, 0.6f));
        this.player = new Player(40, 120);
    }

    // Methoden
    public void update (long elapsedTime) {
        for (Car car : cars){
            car.update(elapsedTime);
        }
    }

    // Setter + Getter
    public List<Car> getCars() {
        return cars;
    }

    public Player getPlayer() {
        return player;
    }
}
