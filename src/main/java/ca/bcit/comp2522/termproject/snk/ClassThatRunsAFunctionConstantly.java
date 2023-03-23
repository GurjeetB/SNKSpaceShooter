package ca.bcit.comp2522.termproject.snk;

import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
/*
    Runs a function constantly.
    Must implement tick().
*/
public abstract class ClassThatRunsAFunctionConstantly extends AnimationTimer {
    long pauseStart;
    long animationStart;
    DoubleProperty animationDuration = new SimpleDoubleProperty(0L);

    long lastFrameTimeNanos;

    boolean isPaused;
    boolean isActive;

    boolean pauseScheduled;
    boolean playScheduled;
    boolean restartScheduled;

    public boolean isActive() {
        return isActive;
    }

    public DoubleProperty animationDurationProperty() {
        return animationDuration;
    }

    @Override
    public void start() {
        super.start();
        isActive = true;
        restartScheduled = true;
    }

    @Override
    public void stop() {
        super.stop();
        pauseStart = 0;
        isActive = false;
        pauseScheduled = false;
        playScheduled = false;
        animationDuration.set(0);
    }

    @Override
    public void handle(long now) {
        if (playScheduled) {
            animationStart += (now - pauseStart);
            playScheduled = false;
        }

        if (restartScheduled) {
            animationStart = now;
            restartScheduled = false;
        }

        if (isActive) {
            long animDuration = now - animationStart;
            animationDuration.set(animDuration / 1e9);

            float secondsSinceLastFrame = (float) ((now - lastFrameTimeNanos) / 1e9);
            lastFrameTimeNanos = now;
            tick(secondsSinceLastFrame);
        }
    }

    public abstract void tick(float secondsSinceLastFrame);
}
