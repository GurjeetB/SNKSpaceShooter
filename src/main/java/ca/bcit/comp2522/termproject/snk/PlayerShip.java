package ca.bcit.comp2522.termproject.snk;

public class PlayerShip extends Character {

        private final int width;
        private final int height;

        private double damage;
        private double speed;
        private double powerUp;


        public PlayerShip(int health, int positionX, int positionY) {
            super(health, positionX, positionY);
            width = 45;
            height = 31;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

    @Override
    Bullet shoot() {
        return new Bullet(positionX, positionY, "player");
    }

    @Override
    int moveLeft() {
        positionX -= 1;
        return positionX;
    }

    @Override
    int moveRight() {
        positionX += 1;
        return positionX;
    }

    @Override
    Destruction explode() {
        return new Destruction(positionX, positionY, "player");
    }



}
