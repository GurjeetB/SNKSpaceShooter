package ca.bcit.comp2522.termproject.snk;

public class PlayerShip extends Character {

        private final int width;
        private final int height;

        public PlayerShip(int health, int positionX, int positionY) {
            super(health, positionX, positionY);
            width = 0;
            height = 0;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

    @Override
    Bullet shoot() {
        return new Bullet();
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
        return new Destruction("player");
    }
}
