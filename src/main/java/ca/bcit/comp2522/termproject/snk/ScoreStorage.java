package ca.bcit.comp2522.termproject.snk;

public class ScoreStorage {
    private static final ScoreStorage SINGLETON = new ScoreStorage();
    public static ScoreStorage getInstance() {
        return SINGLETON;
    }
    private int score;
    private String name;

    private ScoreStorage() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
