package ca.bcit.comp2522.termproject.snk;

import java.util.Objects;

public abstract class Character {
    /**
     * The character's health.
     */
    int health;
    /**
     * The character's horizontal position.
     */
    int positionX;
    int positionY;

    public Character(int health, int positionX, int positionY) {
        this.health = health;
        this.positionX = positionX;
        this.positionY = positionY;
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
    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    /**
     * Deals damage to a character, then checks if their health has been depleted.
     * @param damageDealt The amount of damage to deal. Must be positive.
     * @return True if the character's health is now 0; else, False
     */
    public boolean takeDamage(int damageDealt) {
        this.health -= damageDealt;
        if (this.health <= 0) {
            this.health = 0;
        }
        return this.health == 0;
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

    @Override
    public String toString() {
        return "Character{" +
                "health=" + health +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return getHealth() == character.getHealth()
                && getPositionX() == character.getPositionX()
                && getPositionY() == character.getPositionY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHealth(), getPositionX(), getPositionY());
    }
}
