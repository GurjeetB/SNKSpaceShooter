package ca.bcit.comp2522.termproject.snk;

public class Score {
    private int score;
    private int highScore;

    public Score() {
        score = 0;
        highScore = 0;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void resetScore() {
        score = 0;
    }

    public void resetHighScore() {
        highScore = 0;
    }

    public void updateHighScore() {
        if (score > highScore) {
            highScore = score;
        }
    }
}
