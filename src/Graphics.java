import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.Car;
import model.Model;

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
        gc.clearRect(0,0, Model.WIDTH, Model.HEIGHT);

        // Draw Cars
        for (Car car : this.model.getCars()) {
            gc.setFill(Color.YELLOW);
            gc.fillRect(
                    car.getX() - car.getW()/2,
                    car.getY() - car.getH()/2,
                    car.getW(),
                    car.getH()
            );
        }


        // Draw Player
        gc.setFill(Color.GREEN);
        gc.fillOval(
                model.getPlayer().getX() - model.getPlayer().getW()/2,
                model.getPlayer().getY() - model.getPlayer().getH()/2,
                model.getPlayer().getW(),
                model.getPlayer().getH()
        );
    }










}
