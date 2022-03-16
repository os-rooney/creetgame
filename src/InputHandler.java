import javafx.scene.input.KeyCode;
import model.Model;

public class InputHandler {

    // Eigenschaften
    private Model model;

    // Konstruktoren
    public InputHandler (Model model) {
        this.model = model;
    }

    // Methoden
    public void onKeyPressed(KeyCode key) {
        if (key == KeyCode.UP) {
            model.getPlayer().move(0,-30);
        }
        else if(key == KeyCode.DOWN) {
            model.getPlayer().move(0,30);
        }
        else if(key == KeyCode.LEFT) {
            model.getPlayer().move(-30,0);
        }
        else if(key == KeyCode.RIGHT) {
            model.getPlayer().move(30,0);
        } else if(key == KeyCode.R){
            model.getPlayer().restart();
        }
    }

}
