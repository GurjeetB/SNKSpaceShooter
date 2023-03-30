package ca.bcit.comp2522.termproject.snk;

public class Bullet {

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
                this.speed = 15;
                this.damage = 10;
            }
            case "alien" -> {
                this.speed = 7;
                this.damage = 50;
            }
        }
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
