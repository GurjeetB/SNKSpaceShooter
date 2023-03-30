package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;

import java.io.IOException;

public class TitleScreenController {

    @FXML
    protected void onHelloButtonClick() throws IOException {
        MainDriver.changeSceneFromFXML("game-screen.fxml");
    }
}

