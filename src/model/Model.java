package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

    // FINALS
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    public static boolean START_GAME = false;
    public static boolean WIN_GAME = false;
    public static boolean LOSE_GAME = false;


    // Properties
    private List<Car> cars = new ArrayList<Car>();
    private Player player;

    // Konstructors
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

    // Methods
    public void update (long elapsedTime) {
        for (Car car : cars){
            car.update(elapsedTime);
        }
    }

    // Collision detection
    public boolean checkCollision(){
        boolean collided = false;
        for(Car car : cars){
            if(checkIfCarHitsPlayer(car, collided)){
                accident();
            }
        }
        return collided;
    }

    // End Game - You Win
    public void youWin(){
        WIN_GAME = true;
    }

    // will be executed in case of collision
    public void accident(){
        LOSE_GAME = true;
    }

    /**
     * check if the car hits the player (collision)
     * @param car
     * @param collided
     * @return true if a car and the player are collided
     */
    public boolean checkIfCarHitsPlayer(Car car, boolean collided){
        // check collisions on X axis
        int playerAreaOnXAxis = player.getX() + player.getW();
        int carAreaOnXAxis = car.getX() + car.getW();
        int carAreaOnYAxis = car.getY() + car.getH();
        int playerAreaOnYAxis = player.getY() + player.getH();
        int playerOnY = player.getY();
        int carOnY = car.getY();
        int playerOnX = player.getX();
        int carOnX = car.getX();
        int playerWidth = player.getW();
        int playerHeight = player.getW();
        int carWidth = car.getW();

        if((playerOnX >= carOnX &&
                // check collisions on X axis
                (playerAreaOnXAxis) <=  (carAreaOnXAxis)) || (playerOnX >= carOnX &&
                        (playerOnX - playerWidth) <= (carOnX - carWidth))){

                // check collisions on Y axis
                if((playerOnY >= carOnY &&
                        (playerAreaOnYAxis <= (carAreaOnYAxis))) || (playerOnY >= carOnY &&
                                (playerOnY - playerHeight <= (carOnY)))){
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
