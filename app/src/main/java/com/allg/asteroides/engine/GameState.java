package com.allg.asteroides.engine;

public class GameState {

    public enum State {

        INTRO,
        RUNNING,
        END
    }

    private State currentState;

    public GameState(State value) {
        currentState = value;
    }

    public GameState() {
        currentState = State.INTRO;
    }

    public State getState() {
        return currentState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

}
