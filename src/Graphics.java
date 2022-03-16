import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Car;
import model.Model;

import java.text.FieldPosition;

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
    public void draw() {

        // Clear Screen
        gc.setFill(Color.rgb(218,218,218));
        gc.fillRect(0,0, Model.WIDTH, Model.HEIGHT);

        // Draw road marking
        for (int i = 0; i < Model.WIDTH; i+=70) {
            gc.setFill(Color.BLACK);
            gc.fillRect(10 + i, 405, 30, 5);
            gc.fillRect(10 + i, 510, 30, 5);
            gc.fillRect(10 + i, 615, 30, 5);
        }

        // Draw sidewalks
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 300, 1000, 4);
        gc.fillRect(0, 715, 1000, 4);


        // Draw Cars
        for (Car car : this.model.getCars()) {
            gc.setFill(Color.YELLOW);
            gc.fillRoundRect(car.getX() - car.getW()/2,
                    car.getY() - car.getH()/2,
                    car.getW(),
                    car.getH(),
                    7,
                    100
            );
        }


        // Draw Player
        gc.setFill(Color.GREEN);
        gc.fillOval(
                (model.getPlayer().getX() - model.getPlayer().getW()/2) + 450,
                (model.getPlayer().getY() - model.getPlayer().getH()/2) + 650,
                model.getPlayer().getW(),
                model.getPlayer().getH()
        );
    }










}
