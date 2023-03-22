package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class TitleScreenController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

