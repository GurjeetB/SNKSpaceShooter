package ca.bcit.comp2522.termproject.snk;

import javafx.collections.ObservableList;
import javafx.scene.Node;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Text; // added to show score
import javafx.scene.text.Font; // added to show score

import java.util.ArrayList;

public class GraphicsEngine {
    private static GraphicsEngine singleton;
    public static GraphicsEngine getInstance(AnchorPane gameRoot) {
        if (singleton == null) {
            singleton = new GraphicsEngine(gameRoot);
        }
        return singleton;
    }
    private final ObservableList<Node> allEntities;
    private GraphicsEngine(AnchorPane gameRoot) {
        allEntities = gameRoot.getChildren();
    }

    public void refreshScreen() {
        allEntities.clear();
    }

    public void renderPlayer(PlayerShip playerShip) {
        // Load the player's sprite image
        Image playerSprite = new Image("file:./src/main/resources/images/PlayerShip.png"); // Turns out, Java's working directory is the initial project folder???
        // Create an ImageView object for the player's sprite
        ImageView playerImageView = new ImageView(playerSprite);

        // Set the position of the ImageView to the player's position
        playerImageView.setX(playerShip.getPositionX() - (playerSprite.getWidth() / 2));
        playerImageView.setY(playerShip.getPositionY());

        // Set the ship's width and height
        playerImageView.setFitWidth(playerSprite.getWidth());
        playerImageView.setFitHeight(playerSprite.getHeight());
        // Turns the ship to face the right way
        playerImageView.setRotate(180);
        // Add the ImageView to the list of all entities
        allEntities.add(playerImageView);
    }

/*    public void renderAliens(ArrayList<Alien> alienList) {
        alienList.forEach(alien -> {
            Circle alienSprite = new Circle(alien.getPositionX(), alien.getPositionY(), 20);
            allEntities.add(alienSprite);
        });
    }*/

    // Attempt to render Alien image; this doesn't work.
    public void renderAliens(ArrayList<Alien> alienList) {
        // Load the alien sprite image
        Image alienSprite = new Image("file:./src/main/resources/images/alienShip.png");
        // (Okay, so we MAY have forgotten to actually add this image to the GitHub...)
        alienList.forEach(alien -> {
            // Create an ImageView object for the alien sprite
        ImageView alienImageView = new ImageView(alienSprite);

        // Set the position of the ImageView to the alien's position
        alienImageView.setX(alien.getPositionX() - 20);
        alienImageView.setY(alien.getPositionY());

        // Set the alien's width and height
        alienImageView.setFitWidth(40);
        alienImageView.setFitHeight(40);
        // Add the ImageView to the list of all entities
        allEntities.add(alienImageView);
    });
}


    public void renderBullets(ArrayList<Bullet> bulletList) {
        bulletList.forEach(bullet -> {
            Rectangle bulletSprite = new Rectangle(bullet.getX(), bullet.getY(), 5, 5);
            switch (bullet.getBulletType()) {
                case "alien" -> {bulletSprite.setFill(Color.RED);}
                case "player" -> {bulletSprite.setFill(Color.YELLOW);}
            }
            allEntities.add(bulletSprite);
        });
    }

    public void renderScore(int score, PlayerShip playerShip) {
        // Create a Text object to display the score
        Text scoreText = new Text("Score: " + score);
        scoreText.setFont(new Font(20));
        scoreText.setFill(Color.WHITE);
        scoreText.setX(playerShip.getPositionX() - playerShip.getWidth());
        scoreText.setY(playerShip.getPositionY() + 50);
        // Add the Text object to the list of all entities
        allEntities.add(scoreText);
    }


}
