package ca.bcit.comp2522.termproject.snk;

import java.util.Objects;

public class PlayerShip extends Character {

        private final int width;
        private final int height;


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
        positionX -= 3;
        return positionX;
    }

    @Override
    int moveRight() {
        positionX += 3;
        return positionX;
    }

    @Override
    Destruction explode() {
        return new Destruction(positionX, positionY, "player");
    }

    @Override
    public String toString() {
        return "PlayerShip{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PlayerShip that = (PlayerShip) o;
        return getWidth() == that.getWidth() && getHeight() == that.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWidth(), getHeight());
    }
}
