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
            this.cars.add(new Car(-i*85, 355, -0.1f));
            //this.cars.add(new Car(i*65, 460, 0.1f));
            //this.cars.add(new Car(-i*55, 565, -0.1f));
            //this.cars.add(new Car(i*35, 670, 0.1f));
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
        for (Car car: cars) {
            if(player.getX() >= car.getX() &&
                    (player.getX() + player.getW()) <=  (car.getX() + car.getW())){

                    if(player.getY() <= car.getY() && (player.getY() + player.getH()) <= (car.getY() + car.getH())){
                        collided = true;
                    }
            }
        }
        return collided;
    }

    // End Game - You Win
    public void youWin(){
        System.out.println("CONGRATULATIONS - YOU WIN");
        getPlayer().restart();
        if(getPlayer().getW() != 60) {
            getPlayer().setW(getPlayer().getW() + 5);
            getPlayer().setH(getPlayer().getH() + 5);
        }
    }

    // accident
    public void accident(){
        if(getPlayer().getW() == 30){
            getPlayer().restart();
        }
        if(getPlayer().getW() >= 30){
            getPlayer().setW(getPlayer().getW() - 5);
            getPlayer().setH(getPlayer().getH() - 5);
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
