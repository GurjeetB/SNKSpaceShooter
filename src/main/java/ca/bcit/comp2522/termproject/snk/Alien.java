package ca.bcit.comp2522.termproject.snk;

public class Alien extends Character {
    private static final int DEFAULT_FIRE_COOLDOWN = 100;
    private int cooldownBeforeShooting;
    public Alien(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        cooldownBeforeShooting = DEFAULT_FIRE_COOLDOWN;
    }

    public boolean isReadyToFire() {
        if (cooldownBeforeShooting == 0) {
            cooldownBeforeShooting = DEFAULT_FIRE_COOLDOWN;
            return true;
        } else {
            cooldownBeforeShooting -= 1;
            return false;
        }
    }

    @Override
    Bullet shoot() {
        System.out.println("BOOM!");
        return new Bullet(positionX, positionY, "alien");
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
        return new Destruction(positionX, positionY, "alien");
    }
}
