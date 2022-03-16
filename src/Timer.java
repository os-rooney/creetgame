import javafx.animation.AnimationTimer;
import model.Model;

public class Timer extends AnimationTimer {

    // Eigenschaften
    private long previousTime = -1;
    private Model model;
    private Graphics graphics;

    // Kontruktoren
    public Timer(Model model, Graphics graphics) {
        this.model = model;
        this.graphics = graphics;
    }

    // Methoden
    @Override
    public void handle(long nowNano) {
        long nowMilli = nowNano/1000000;
        long elapsedTime;
        if (previousTime == -1) {
            elapsedTime = 0;
        } else {
            elapsedTime = nowMilli - previousTime;
        }

        previousTime = nowMilli;

        model.update(elapsedTime);
        graphics.draw();

    }
}
