package ca.bcit.comp2522.termproject.snk;

import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Game {
        private static Game gameSingleton;
        public static Game getInstance() {
            if (gameSingleton == null) {
                gameSingleton = new Game();
            }
            return gameSingleton;
        }
        private final PlayerShip playerShip;
        private final ArrayList<Destruction> destructions;
        private final ArrayList<Bullet> bullets;
        private final ArrayList<Alien> aliens;

        private Game() {
            playerShip = new PlayerShip(100, 320, 320);
            destructions = new ArrayList<>();
            bullets = new ArrayList<>();
            aliens = new ArrayList<>();
        }

        public PlayerShip getPlayerShip() {
            return playerShip;
        }

        public ArrayList<Destruction> getDestruction() {
            return destructions;
        }

        public ArrayList<Bullet> getBullet() {
            return bullets;
        }
        public ArrayList<Alien> getAliens() {
            return aliens;
        }
        public void runAllGameLogic() {
            // Runs all possible game logic
            System.out.println("Game logic is running!");
        }
}
