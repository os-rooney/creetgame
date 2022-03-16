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
        this.cars.add(new Car(0, 355, 0.7f));
        this.cars.add(new Car(0, 455, 0.5f));
        this.cars.add(new Car(0, 555, 0.3f));
        this.cars.add(new Car(0, 655, 0.1f));
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
