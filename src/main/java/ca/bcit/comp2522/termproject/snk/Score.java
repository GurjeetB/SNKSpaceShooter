package ca.bcit.comp2522.termproject.snk;

import java.util.ArrayList;

public class Score implements Comparable<Score> { // Stores each individual game score
    private final int score; // The score that the player got
    private final String name; // The name of the player

    public Score(int score, String name) {
        this.score = score;
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Score o) {
        return Integer.compare(this.getScore(), o.getScore());
    }
}
