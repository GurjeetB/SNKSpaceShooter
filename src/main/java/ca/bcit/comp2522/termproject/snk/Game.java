package ca.bcit.comp2522.termproject.snk;

public class Game {

        private final PlayerShip playerShip;
        private final Destruction destruction;
        private final Bullet bullet;

        public Game() {
            playerShip = new PlayerShip();
            destruction = new Destruction();
            bullet = new Bullet();
        }

        public PlayerShip getPlayerShip() {
            return playerShip;
        }

        public Destruction getDestruction() {
            return destruction;
        }

        public Bullet getBullet() {
            return bullet;
        }
}
