import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Model;


public class MainSpiel extends Application {

    // Eigenschaften initialisieren
    private Timer timer;

    // Konstruktoren

    // Methoden
    @Override
    public void start(Stage stage) throws Exception {



        /* javaFX Vorbereitungen / Stage
        /////////////////////////////////*/

        // Canvas
        Canvas canvas = new Canvas(Model.WIDTH, Model.HEIGHT);

        // Group
        Group group = new Group();
        group.getChildren().add(canvas);

        //Scene
        Scene scene = new Scene(group);

        // Stage
        stage.setScene(scene);
        stage.show();

        // Draw
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Model model = new Model();
        Graphics graphics = new Graphics(model,gc);
        timer = new Timer(model, graphics);
        timer.start();

        // InputHandler
        InputHandler inputHandler = new InputHandler(model);
        scene.setOnKeyPressed(
                event -> inputHandler.onKeyPressed(event.getCode())
        );
        

    }

    @Override
    public void stop() throws Exception {
        timer.stop();
        super.stop();
    }
}
