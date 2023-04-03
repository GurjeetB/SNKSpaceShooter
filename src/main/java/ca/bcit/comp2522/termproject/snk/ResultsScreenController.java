package ca.bcit.comp2522.termproject.snk;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ResultsScreenController {
    public AnchorPane gameRoot;
    public Button exit_button;

    public void stopGame(){
        // Write the score to the scoreboard
        // Save the scoreboard as a file
        Stage stage = (Stage) gameRoot.getScene().getWindow();
        stage.close();
    }
}
