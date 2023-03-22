package ca.bcit.comp2522.termproject.snk;

public abstract class Character {
    /**
     * The character's health.
     */
    int health;
    /**
     * The character's horizontal position.
     */
    int positionX;

    public Character(int health, int positionX) {
        this.health = health;
        this.positionX = positionX;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     * Creates a bullet at the Character's position.
     * @return A new instance of a bullet
     */
    abstract Bullet shoot();

    /**
     * Moves the Character left, then returns its new horizontal position.
     * @return The character's new horizontal position
     */
    abstract int moveLeft();
    /**
     * Moves the Character left, then returns its new horizontal position.
     * @return The character's new horizontal position
     */
    abstract int moveRight();

    /**
     * Creates an Explosion at the Character's position.
     * @return A new instance of an Explosion
     */
    abstract Destruction explode();
}
