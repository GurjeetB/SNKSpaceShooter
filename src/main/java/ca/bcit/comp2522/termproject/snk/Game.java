package ca.bcit.comp2522.termproject.snk;

import java.util.ArrayList;

public class Game {

        private final PlayerShip playerShip;
        private final ArrayList<Destruction> destructions;
        private final ArrayList<Bullet> bullets;
        private final ArrayList<Alien> aliens;

        public Game() {
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
}
