package ca.bcit.comp2522.termproject.snk;

import javafx.collections.ObservableList;
import javafx.scene.Node;
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
