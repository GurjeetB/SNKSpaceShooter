package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

public class TitleScreenController {

    public Button startButton;
    public TextField playerNameEntry;
    public Text snkTextLogo;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        if (playerNameEntry.getText().isBlank()) {
            System.out.println("ENTER A NAME");
        } else {
            ScoreStorage.getInstance().setName(playerNameEntry.getText());
            MainDriver.changeSceneFromFXML("game-screen.fxml");
        }
    }
}

