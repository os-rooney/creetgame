import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import model.Car;
import model.Model;

import java.awt.*;
import javafx.scene.image.Image;


public class Graphics {

    // Eigenschaften
    private Model model;
    private GraphicsContext gc;

    // Konstruktoren
    public Graphics(Model model, GraphicsContext gc) {
        this.model = model;
        this.gc = gc;
    }

    // Methoden
    public void drawStartPage(){
        // Clear Screen
        Image img = new Image("img\\carGreen.PNG");
        gc.drawImage(img, 430, 350, 100, 50);
        gc.setFont(new Font("Arial", 24));
        gc.fillText("Press ENTER to start the game", 320, 450);
    }


    public void draw() {

        // Clear Screen
        gc.setFill(Color.DARKSLATEGREY);
        gc.fillRect(0,0, Model.WIDTH, Model.HEIGHT);



        // Draw road marking
        for (int i = 0; i < Model.WIDTH; i+=70) {
            gc.setFill(Color.WHITE);
            gc.fillRect(10 + i, 250, 30, 5);
            gc.fillRect(10 + i, 350, 30, 5);
            gc.fillRect(10 + i, 450, 30, 5);
            gc.fillRect(10 + i, 550, 30, 5);
            gc.fillRect(10 + i, 650, 30, 5);
            gc.fillRect(10 + i, 750, 30, 5);
        }

        // Draw sidewalks
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 150, 1000, 4);
        gc.fillRect(0, 850, 1000, 4);

        // Draw Cars
        Image carImageYellow = new Image("img\\carYellow.PNG");
        Image carImageRed = new Image("img\\carRed.PNG");
        Image carImageYellowReversed = new Image("img\\carYellowReversed.PNG");
        Image carImageRedReversed = new Image("img\\carReversedRed.PNG");

        ImagePattern patternY = new ImagePattern(carImageYellow);
        ImagePattern patternReversedY = new ImagePattern(carImageYellowReversed);
        ImagePattern patternReversedR = new ImagePattern(carImageRedReversed);
        ImagePattern patternR = new ImagePattern(carImageRed);

        for (Car car : this.model.getCars()) {
                if(car.getSpeedX() < 0){
                    if(car.getId() % 2 == 0){
                        gc.setFill(patternReversedR);
                        gc.fillRect(car.getX(),
                                car.getY(),
                                car.getW(),
                                car.getH()
                        );
                    } else {
                        gc.setFill(patternReversedY);
                        gc.fillRect(car.getX(),
                                car.getY(),
                                car.getW(),
                                car.getH()
                        );
                    }
                } else if(car.getSpeedX() > 0){
                    if(car.getId() % 3 == 0){
                        gc.setFill(patternY);
                        gc.fillRect(car.getX(),
                                car.getY(),
                                car.getW(),
                                car.getH()
                        );
                    } else {
                        gc.setFill(patternR);
                        gc.fillRect(car.getX(),
                                car.getY(),
                                car.getW(),
                                car.getH()
                        );
                    }
                }
            }

        // Draw Player
        Image cat = new Image("img\\cat.png");
        ImagePattern patternCat = new ImagePattern(cat);
        gc.setFill(patternCat);
        gc.fillRect(
                model.getPlayer().getX(),
                model.getPlayer().getY(),
                model.getPlayer().getW(),
                model.getPlayer().getH()
        );
    }










}
