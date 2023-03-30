package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameScreenController implements Initializable {
    private GraphicsEngine graphicsEngine;
    public AnchorPane gameRoot;
    ClassThatRunsAFunctionConstantly testClass = new ClassThatRunsAFunctionConstantly() {
        @Override
        public void tick(float secondsSinceLastFrame) {
            runAllGameLogic();
            runAllJavaFXLogic();
        }
    };
    private boolean playerIsMoving;
    private int playerMovementDirection;
    private final PlayerShip playerShip = new PlayerShip(100, 320, 320);
    private final ArrayList<Destruction> destructions = new ArrayList<>();
    private final ArrayList<Bullet> bullets = new ArrayList<>();
    private final ArrayList<Alien> aliens = new ArrayList<>();

    @FXML
    public void onKeyPressed(KeyEvent event) {
        switch (event.getCode()) {
            case A -> {
                playerMovementDirection = -1;
                playerIsMoving = true;
            }
            case D -> {
                playerMovementDirection = 1;
                playerIsMoving = true;
            }
        }
    }

    @FXML
    public void onKeyReleased(KeyEvent event) {
        switch (event.getCode()) {
            case A, D -> {
                playerMovementDirection = 0;
                playerIsMoving = false;
            }
            case J -> {bullets.add(playerShip.shoot());}
        }
    }

    /* These two functions run constantly. Like, ALL the time. */
    private void runAllJavaFXLogic() {
        graphicsEngine.refreshScreen();
        graphicsEngine.renderPlayer(playerShip);
        graphicsEngine.renderAliens(aliens);
        graphicsEngine.renderBullets(bullets);
    }

    public void runAllGameLogic() {
        // Runs all possible game logic
        // Spawns a new alien if there is none
        if (aliens.size() == 0) {
            aliens.add(new Alien(25, 100, 100));
        }
        aliens.stream().filter(Alien::isReadyToFire).forEach(alien -> bullets.add(alien.shoot()));
        // Moves the ship around if a key's being pressed
        if(playerIsMoving) {
            switch (playerMovementDirection) {
                case 1 -> {playerShip.moveRight();}
                case -1 -> {playerShip.moveLeft();}
            }
        }

        // Makes bullets move
        bullets.forEach(Bullet::move);
        // Removes bullets if they're off-screen
        bullets.removeIf(bullet -> !bullet.isOnScreen(gameRoot.getWidth(), gameRoot.getHeight()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        graphicsEngine = GraphicsEngine.getInstance(gameRoot);
        testClass.start();
    }
}
