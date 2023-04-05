package ca.bcit.comp2522.termproject.snk;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
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
    private int playerScore;
    private final PlayerShip playerShip = new PlayerShip(100, 320, 320);
    private final ArrayList<Destruction> destructions = new ArrayList<>();
    private final ArrayList<Bullet> bullets = new ArrayList<>();
    private final ArrayList<Alien> aliens = new ArrayList<>();

    private int score = 0; // initialize score to 0

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
            case Y -> {stopGame();}
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

        bullets.forEach(bullet -> {
            switch (bullet.getBulletType()) {
                case "player" -> {
                    aliens.forEach(alien -> {
                        if (bullet.getCharacterHit(alien, 20)) {
                            ++playerScore;
                            if (alien.takeDamage(bullet.getDamage())) {
                                playerScore += 10;
                                destructions.add(alien.explode());
                                System.out.println("Score: " + playerScore);
                            }
                            bullet.setY(-10);
                        }
                    });
                }
                case "alien" -> {
                    if (bullet.getCharacterHit(playerShip, 20)) {
                        if (playerShip.takeDamage(bullet.getDamage())) {
                            destructions.add(playerShip.explode());
                            System.out.println("OOF!");
                        }
                        bullet.setY(-10);
                    }
                }
            }
        });

        aliens.removeIf(alien -> alien.getHealth() == 0);
        if (playerShip.getHealth() == 0) {
            stopGame();
        }
    }

    public void stopGame() {
        try {
            ScoreStorage.getInstance().setScore(playerScore);
            testClass.stop();
            MainDriver.changeSceneFromFXML("results-screen.FXML");
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playerScore = 0;
        graphicsEngine = GraphicsEngine.getInstance(gameRoot);
        GraphicsEngine.getInstance(gameRoot).renderScore(score); // added to render score
        testClass.start();
    }
}
