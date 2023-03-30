package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {
    ClassThatRunsAFunctionConstantly testClass = new ClassThatRunsAFunctionConstantly() {
        @Override
        public void tick(float secondsSinceLastFrame) {
            runAllGameLogic();
            runAllJavaFXLogic();
        }
    };
    private boolean playerIsMoving;
    private final PlayerShip playerShip = new PlayerShip(100, 320, 320);;
    private final ArrayList<Destruction> destructions = new ArrayList<>();
    private final ArrayList<Bullet> bullets = new ArrayList<>();
    private final ArrayList<Alien> aliens = new ArrayList<>();

    @FXML
    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.A) {
            playerIsMoving = true;
        }
    }

    @FXML
    public void onKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.A) {
            playerIsMoving = false;
        }
    }

    /* These two functions run constantly. Like, ALL the time. */
    private void runAllJavaFXLogic() {
        if(playerIsMoving) {
            System.out.println("JavaFX is detecting a key press!");
        }
    }

    public void runAllGameLogic() {
        // Runs all possible game logic
        System.out.println("Game logic is running!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testClass.start();
    }
}
