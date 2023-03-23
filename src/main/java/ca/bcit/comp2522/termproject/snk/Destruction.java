package ca.bcit.comp2522.termproject.snk;

public class Destruction {
    private final int x;
    private final int y;
    private final String explosionType;

    public Destruction(int x, int y, String explosionType) {
        this.x = x;
        this.y = y;
        this.explosionType = explosionType;
    }

    public String getExplosionType() {
        return explosionType;
    }
}
