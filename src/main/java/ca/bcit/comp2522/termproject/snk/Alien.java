package ca.bcit.comp2522.termproject.snk;

import java.util.Random;

/**
 * Alien enemy.
 */
public class Alien extends Character {
    private static final int DEFAULT_FIRE_COOLDOWN = 100;
    private static final int DEFAULT_MOVEMENT_DIRECTION = 1;
    private int cooldownBeforeShooting;
    private int movementDirection;

    /**
     * Constructs a new Alien.
     * @param health The alien's health
     * @param positionX The alien's horizontal position in pixels
     * @param positionY The alien's vertical position in pixels
     */
    public Alien(int health, int positionX, int positionY) {
        super(health, positionX, positionY);
        cooldownBeforeShooting = DEFAULT_FIRE_COOLDOWN;
        movementDirection = DEFAULT_MOVEMENT_DIRECTION;
    }

    /**
     * Determines if the Alien's cooldown is low enough for it to fire.
     * If unable to fire yet, progresses the Alien's cooldown further.
     * @return If the Alien can safely fire, True; else, False
     */
    public boolean isReadyToFire() {
        if (cooldownBeforeShooting == 0) {
            cooldownBeforeShooting = new Random().nextInt(50, 300);
            return true;
        } else {
            cooldownBeforeShooting -= 1;
            return false;
        }
    }

    /**
     * Determines if the Alien is horizontally outside the screen.
     * @param screenWidth The width of the screen in pixels
     * @return If the alien is off-screen, True; else, False
     */
    public boolean isOffScreen(double screenWidth) {
        return positionX <= 0 || positionX >= screenWidth;
    }

    /**
     * Toggle the Alien's movement state between moving left and right.
     * Use in conjunction with moveFromDirection().
     */
    public void toggleMovement() {
        if (movementDirection == 1) {
            movementDirection = -1;
        } else if (movementDirection == -1) {
            movementDirection = 1;
        }
    }

    /**
     * Moves the Alien either left or right depending on its current movement state.
     */
    public void moveFromDirection() {
        if (movementDirection == 1) {
            moveRight();
        } else if (movementDirection == -1) {
            moveLeft();
        }
    }

    /**
     * Creates a new Bullet at the Alien's position.
     * @return A new Bullet
     */
    @Override
    Bullet shoot() {
        return new Bullet(positionX, positionY, "alien");
    }

    /**
     * Moves the Alien to the left, then returns its new horizontal position.
     * @return The Alien's new horizontal position
     */
    @Override
    int moveLeft() {
        positionX -= 2;
        return positionX;
    }

    /**
     * Moves the Alien to the right, then returns its new horizontal position.
     * @return The Alien's new horizontal position
     */
    @Override
    int moveRight() {
        positionX += 2;
        return positionX;
    }

    /**
     * Creates a new Destruction entity at the Alien's position.
     * @return A new Destruction entity.
     */
    @Override
    Destruction explode() {
        return new Destruction(positionX, positionY, "alien");
    }
}
