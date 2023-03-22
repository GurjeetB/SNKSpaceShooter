package ca.bcit.comp2522.termproject.snk;

public class Alien extends Character {

    public Alien(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
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
        return new Destruction("alien");
    }
}
