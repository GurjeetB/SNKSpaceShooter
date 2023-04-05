package ca.bcit.comp2522.termproject.snk;

import javafx.collections.ObservableList;
import javafx.scene.Node;
 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
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

    public void renderAliens(ArrayList<Alien> alienList) {
        alienList.forEach(alien -> {
            Circle alienSprite = new Circle(alien.getPositionX(), alien.getPositionY(), 20);
            allEntities.add(alienSprite);
        });
    }

    //// Attempt to render Alien image; this doesn't work.
//public void renderAliens(ArrayList<Alien> alienList) {
//        // Load the alien sprite image
//        Image alienSprite = new Image("file:./src/main/resources/images/alienShip.png");
//        alienList.forEach(alien -> {
//            // Create an ImageView object for the alien sprite
//        ImageView alienImageView = new ImageView(alienSprite);
//
//        // Set the position of the ImageView to the alien's position
//        alienImageView.setX(alien.getPositionX() - (alienSprite.getWidth() / 2));
//        alienImageView.setY(alien.getPositionY());
//
//        // Set the alien's width and height
//        alienImageView.setFitWidth(alienSprite.getWidth());
//        alienImageView.setFitHeight(alienSprite.getHeight());
//        // Add the ImageView to the list of all entities
//        allEntities.add(alienImageView);
//    });
//}


    public void renderBullets(ArrayList<Bullet> bulletList) {
        bulletList.forEach(bullet -> {
            Rectangle bulletSprite = new Rectangle(bullet.getX(), bullet.getY(), 5, 5);
            allEntities.add(bulletSprite);
        });
    }

    // render score doesn't work. I don't know why.
    public void renderScore(int score) {
        // Create a Text object to display the score
        Text scoreText = new Text("Score: " + score);
        scoreText.setFont(new Font(20));
        scoreText.setX(10);
        scoreText.setY(30);
        // Add the Text object to the list of all entities
        allEntities.add(scoreText);
    }


}
