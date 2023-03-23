package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.security.Key;
import java.util.Objects;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {
    Game game = Game.getInstance();
    ClassThatRunsAFunctionConstantly testClass = new ClassThatRunsAFunctionConstantly() {
        @Override
        public void tick(float secondsSinceLastFrame) {
            game.runAllGameLogic();
            runAllJavaFXLogic();
        }
    };
    private boolean playerIsMoving;

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

    private void runAllJavaFXLogic() {
        if(playerIsMoving) {
            System.out.println("JavaFX is detecting a key press!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testClass.start();
    }
}
