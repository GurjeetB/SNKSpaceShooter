package ca.bcit.comp2522.termproject.snk;

public class Alien extends Character {
    private static final int DEFAULT_FIRE_COOLDOWN = 100;
    private static final int DEFAULT_MOVEMENT_DIRECTION = 1;
    private int cooldownBeforeShooting;
    private int movementDirection;
    public Alien(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        cooldownBeforeShooting = DEFAULT_FIRE_COOLDOWN;
        movementDirection = DEFAULT_MOVEMENT_DIRECTION;
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

    public boolean isOffScreen(double screenWidth) {
        return positionX <= 0 || positionX >= screenWidth;
    }

    public void toggleMovement() {
        if (movementDirection == 1) {
            movementDirection = -1;
        } else if (movementDirection == -1) {
            movementDirection = 1;
        }
    }

    public void moveFromDirection() {
        if (movementDirection == 1) {
            moveRight();
        } else if (movementDirection == -1) {
            moveLeft();
        }
    }

    @Override
    Bullet shoot() {
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
