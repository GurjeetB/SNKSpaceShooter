package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.security.Key;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {
    Game game = Game.getInstance();
    ClassThatRunsAFunctionConstantly testClass = new ClassThatRunsAFunctionConstantly() {
        @Override
        public void tick(float secondsSinceLastFrame) {
            game.runAllGameLogic();
        }
    };

    @FXML
    public void onKeyPressed(KeyEvent event) {
        game.onKeyPressed(event);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testClass.start();
    }
}
