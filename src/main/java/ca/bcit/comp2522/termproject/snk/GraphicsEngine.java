package ca.bcit.comp2522.termproject.snk;

import javafx.collections.ObservableList;
import javafx.scene.Node;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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

    public void renderAliens(ArrayList<Alien> alienList) {
        alienList.forEach(alien -> {
            Circle alienSprite = new Circle(alien.getPositionX(), alien.getPositionY(), 20);
            allEntities.add(alienSprite);
        });
    }

    public void renderBullets(ArrayList<Bullet> bulletList) {
        bulletList.forEach(bullet -> {
            Rectangle bulletSprite = new Rectangle(bullet.getX(), bullet.getY(), 5, 5);
            allEntities.add(bulletSprite);
        });
    }

}
