package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ResultsScreenController implements Initializable {
    public AnchorPane gameRoot;
    public Button exit_button;
    public Text yourScoreWas;

    public void stopGame(){
        // Write the score to the scoreboard
        // Save the scoreboard as a file
        Stage stage = (Stage) gameRoot.getScene().getWindow();
        stage.close();
    }

    private void saveScoreboardToFile(Scoreboard scoreboard, String filePath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream output = new ObjectOutputStream(fileOut);
            output.writeObject(scoreboard);
            output.flush();
            output.close();
            System.out.println("Saved scoreboard in " + filePath);
        } catch (IOException e) {
            System.out.println("Could not save to " + filePath);
        }
    }

    private Scoreboard getScoreboardFromFile(String filePath){
        Scoreboard result = Scoreboard.getInstance();
        try {
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream input = new ObjectInputStream(fileIn);
            result = (Scoreboard) input.readObject();
            input.close();
            fileIn.close();
            System.out.println("Opened scoreboard at" + filePath);
        } catch (IOException e) {
            System.out.println("could not open " + filePath);
        } catch (ClassNotFoundException e) {
            System.out.println(filePath + "is not a scoreboard");
        }
        return result;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Score scoreFromLastRun = new Score(ScoreStorage.getInstance().getScore(), ScoreStorage.getInstance().getName());
        yourScoreWas.setText(String.format("%s", scoreFromLastRun.getScore()));
        Scoreboard mostRecentScoreboard = getScoreboardFromFile("scoreboard.ser");
        mostRecentScoreboard.addScoreToList(scoreFromLastRun);
        System.out.println(mostRecentScoreboard);
        saveScoreboardToFile(mostRecentScoreboard, "scoreboard.ser");
    }
}
