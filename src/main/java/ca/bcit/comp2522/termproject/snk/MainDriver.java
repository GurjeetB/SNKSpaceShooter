package ca.bcit.comp2522.termproject.snk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDriver extends Application {
    public static String APPLICATION_TITLE = "The Game!";
    public static String INITIAL_SCENE = "title-screen.fxml";
    private static Stage mainStage;
    public static void changeSceneFromFXML(String scenePath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainDriver.class.getResource(scenePath));
        Scene newScene = new Scene(fxmlLoader.load(), 640, 480);
        mainStage.setScene(newScene);
        newScene.getRoot().requestFocus();
    }

    @Override
    public void start(Stage initialStage) throws IOException {
        mainStage = initialStage;
        mainStage.setTitle(APPLICATION_TITLE);
        changeSceneFromFXML(INITIAL_SCENE);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}