package ca.bcit.comp2522.termproject.snk;

import java.util.ArrayList;

public class Bullet {
    private static boolean compareDeviation(int v1, int v2, int deviation){
        return (v1 >= (v2 - deviation) && v1 <= (v2 + deviation));
    }

    private int x;
    private int y;
    private int speed;
    private int damage;
    private final String bulletType;

    public Bullet() {
        x = 0;
        y = 0;
        speed = 0;
        damage = 0;
        this.bulletType = "none";
    }

    public Bullet(int positionX, int positionY, String bulletType) {
        this.x = positionX;
        this.y = positionY;
        this.bulletType = bulletType;
        switch (bulletType) {
            case "player" -> {
                this.speed = 10;
                this.damage = 10;
            }
            case "alien" -> {
                this.speed = -5;
                this.damage = 50;
            }
        }
    }

    public void move(){
            y -= speed;
    }

    public boolean isOnScreen(double screenWidth, double screenHeight){
            return x > 0 && x < screenWidth && y > 0 && y < screenHeight;
    }

    public boolean getCharacterHit(Character character, int hitboxSize) {
            return compareDeviation(this.x, character.getPositionX(), hitboxSize)
                    && compareDeviation(this.y, character.getPositionY(), hitboxSize);
    }

    public int getX() {
            return x;
        }

    public void setX(int x) {
            this.x = x;
        }

    public int getY() {
            return y;
        }

    public void setY(int y) {
            this.y = y;
        }

    public int getSpeed() {
            return speed;
        }

    public int getDamage() {
            return damage;
        }

    public String getBulletType() {
        return bulletType;
    }
}
