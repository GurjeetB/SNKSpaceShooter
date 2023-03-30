package ca.bcit.comp2522.termproject.snk;

public class Explosion {
    // define explosion animation frames
    private final int[] frames = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    private int currentFrame;
    private final int x;
    private final int y;

    public Explosion(int x, int y) {
        this.x = x;
        this.y = y;
        currentFrame = 0;
    }
    // get the current frame of the explosion animation
    public int getCurrentFrame() {
        return frames[currentFrame];
    }
    // get the x position of the explosion
    public int getX() {
        return x;
    }
    // get the y position of the explosion
    public int getY() {
        return y;
    }
    // increment the current frame of the explosion animation
    public void nextFrame() {
        currentFrame++;
    }
    // check if the explosion animation is finished
    public boolean isFinished() {
        return currentFrame == frames.length;
    }

    // create explosion animation
    public static Explosion createExplosion(int x, int y) {
        return new Explosion(x, y);
    }

    // Detect collision between explosion and bullet
    public boolean isCollidingWith(Bullet bullet) {
        // check if the bullet x and y is in the same position as alien x and y
        return bullet.getX() == x && bullet.getY() == y;
    }





}
