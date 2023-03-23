package ca.bcit.comp2522.termproject.snk;

public class Bullet {

        private int x;
        private int y;
        private final int speed;
        private final int damage;
        private final String bulletType;

        public Bullet() {
            x = 0;
            y = 0;
            speed = 0;
            damage = 0;
            this.bulletType = "none";
        }

    public Bullet(int x, int y, int speed, int damage, String bulletType) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
        this.bulletType = bulletType;
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
