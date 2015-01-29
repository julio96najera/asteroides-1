package com.allg.asteroides.engine;

public class GameState {

    public enum State {

        RUNNING,
        PLAYER_LOST,
        PLAYER_WIN
    }

    private State currentState;

    public GameState(State value) {
        currentState = value;
    }

    public GameState() {
        currentState = State.RUNNING;
    }

    public State getState() {
        return currentState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void setRunningState() {
        currentState = State.RUNNING;
    }

    public void setPlayerLostState() {
        currentState = State.PLAYER_LOST;
    }

    public void setPlayerWinState() {
        currentState = State.PLAYER_WIN;
    }
}
