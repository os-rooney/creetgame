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
            gc.fillRect(10 + i, 300, 30, 5);
            gc.fillRect(10 + i, 400, 30, 5);
            gc.fillRect(10 + i, 500, 30, 5);
        }

        // Draw sidewalks
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 200, 1000, 4);
        gc.fillRect(0, 600, 1000, 4);

        // Draw Cars
        for (Car car : this.model.getCars()) {
            gc.setFill(Color.YELLOW);
            gc.fillRect(car.getX(),
                    car.getY(),
                    car.getW(),
                    car.getH()
            );
        }

        // Draw Player
        gc.setFill(Color.GREEN);
        gc.fillRect(
                model.getPlayer().getX(),
                model.getPlayer().getY(),
                model.getPlayer().getW(),
                model.getPlayer().getH()
        );
    }










}
