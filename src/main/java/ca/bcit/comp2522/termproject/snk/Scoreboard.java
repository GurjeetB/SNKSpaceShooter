package ca.bcit.comp2522.termproject.snk;

public class Scoreboard {

        private int score;
        private int highScore;

        public Scoreboard() {
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

        public void updateScore(int score) {
            this.score += score;
        }

        public void updateHighScore() {
            if (score > highScore) {
                highScore = score;
            }
        }

        public void resetScore() {
            score = 0;
        }
}
