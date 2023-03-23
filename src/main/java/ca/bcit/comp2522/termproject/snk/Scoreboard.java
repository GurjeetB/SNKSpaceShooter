package ca.bcit.comp2522.termproject.snk;

import java.util.ArrayList;
import java.util.Comparator;

public class Scoreboard {
    private static class ScoreSorter implements Comparator<Score> {
        @Override
        public int compare(Score o1, Score o2) {
            return Integer.compare(o1.compareTo(o2), 0);
        }
    }
    private final ArrayList<Score> topTenScores; // Stores a bunch of Score objects

    public Scoreboard() {
        this.topTenScores = new ArrayList<>();
    }

    public ArrayList<Score> getTopTenScores() {
        return topTenScores;
    }

    public Score getHighestScore() {
        sortScoresByHighest();
        return topTenScores.get(0);
    }

    private void sortScoresByHighest() {
        topTenScores.sort(new ScoreSorter());
    }

    public void createNewScore(int playerScore, String playerName) {
        Score result = new Score(playerScore, playerName);
        topTenScores.add(result);
        sortScoresByHighest();
        if (topTenScores.size() > 10) { // If topTenScores has more than ten cores
            topTenScores.remove(topTenScores.size() + 1); // Removes the last entry from topTenScores
        }
    }
}
