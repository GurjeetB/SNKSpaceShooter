package ca.bcit.comp2522.termproject.snk;

public class Bullet {

        private int x;
        private int y;
        private int speed;
        private int damage;

        public Bullet() {
            x = 0;
            y = 0;
            speed = 0;
            damage = 0;
        }

    public Bullet(int x, int y, int speed, int damage) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.damage = damage;
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

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

}
