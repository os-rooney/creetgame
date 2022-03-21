import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import model.Car;
import model.Model;

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

    // Start Page
    public void drawStartPage(){
        Image img = new Image("img\\carGreen.PNG");
        gc.drawImage(img, 430, 350, 100, 50);
        gc.setFont(new Font("Arial", 24));
        gc.fillText("Press ENTER to start the game", 320, 450);
    }

    // Crashed Page - in case of collision this page will pop up
    public void drawCrashedPage(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, model.HEIGHT, model.WIDTH);
        gc.setFill(Color.BLACK);
        Image img = new Image("img\\crashed.PNG");
        gc.drawImage(img, 430, 350, 100, 50);
        gc.setFont(new Font("Arial", 24));
        gc.fillText("Ooops! You lose", 400, 450);
        gc.setFont(new Font("Arial", 14));
        gc.fillText("Press R to restart the game", 400, 470);
    }

    // Win Page - when player crosses the street this page will pop up
    public void drawWinPage(){
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, model.HEIGHT, model.WIDTH);
        gc.setFill(Color.BLACK);
        Image img = new Image("img\\winner.PNG");
        gc.drawImage(img, 430, 350, 200, 180);
        gc.setFont(new Font("Arial", 24));
        gc.fillText("Congratulations! You win!!", 380, 570);
        gc.setFont(new Font("Arial", 14));
        gc.fillText("Press R to play again!", 450, 590);
    }

    // Game Graphics
    public void draw() {

        // Clear Screen
        gc.setFill(Color.DARKSLATEGREY);
        gc.fillRect(0,0, Model.WIDTH, Model.HEIGHT);



        // Draw road marking
        for (int i = 0; i < Model.WIDTH; i+=70) {
            // street lanes coordination
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

        // Create cars depending on the given ID and driving direction
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
