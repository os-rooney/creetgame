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

        if(model.checkCollision()){
            model.accident();
        }

        if(model.getPlayer().getY() <= 110){
            model.youWin();
        }

        // Check game state to show the right page
        if(!model.START_GAME){
            graphics.drawStartPage();
        } else if(!model.LOSE_GAME && !model.WIN_GAME){
            graphics.draw();
        } else if(model.LOSE_GAME){
            graphics.drawCrashedPage();
        } else if(model.WIN_GAME){
            graphics.drawWinPage();
        }

        // Keep the player in game area
        model.getPlayer().checkPlayerPositionX();
        model.getPlayer().checkPlayerPositionY();
    }

}
