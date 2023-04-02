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
        Circle playerSprite = new Circle(playerShip.getPositionX(),
                playerShip.getPositionY(), 15);
        allEntities.add(playerSprite);
    }

//public void renderPlayer(PlayerShip player) {
//    // Load the player's sprite image ??? cannot get the correct path ???
//    Image playerSprite = new Image("images/PlayerShip.png");
//
//    // Create an ImageView object for the player's sprite
//    ImageView playerImageView = new ImageView(playerSprite);
//
//    // Set the position of the ImageView to the player's position
//    playerImageView.setX(player.getPositionX());
//    playerImageView.setY(player.getPositionY());
//
//    // Set the size of the ImageView
//    playerImageView.setFitWidth(player.getWidth());
//    playerImageView.setFitHeight(player.getHeight());
//
//    // Add the ImageView to the list of all entities
//    allEntities.add(playerImageView);
//}

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
