package com.allg.asteroides.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.allg.asteroides.game.levels.AsteroidesLevelController;

import java.util.ArrayList;
import java.util.List;

public class GameManager extends GameController {

    protected List<ControllerInterface> levels;
    private int current = 0;

    public GameManager(Context context) {
        super(context);
        levels = new ArrayList<>();
    }

    @Override
    public void initObjects(Canvas canvas) {
        getCurrentLevel().initObjects(canvas);
    }

    @Override
    public void stepObjects(Canvas canvas) {
        getCurrentLevel().stepObjects(canvas);
    }

    @Override
    public void drawObjects(Canvas canvas) {
        getCurrentLevel().drawObjects(canvas);
    }

    @Override
    public void stepObjectsFinal(Canvas canvas) {
        getCurrentLevel().stepObjectsFinal(canvas);
    }

    @Override
    public void drawObjectsFinal(Canvas canvas) {
        getCurrentLevel().drawObjectsFinal(canvas);
    }

    @Override
    public void unloadObjects() {
        getCurrentLevel().unloadObjects();
    }

    @Override
    public void touchEvent(MotionEvent event) {
        getCurrentLevel().touchEvent(event);
    }

    private void changeLevel() {
        stop();

        current = ++current % levels.size();
        Log.d("GameManager", "Troca de Nível: current == "+current);

        setGameState(State.INTRO);

        resume();
    }

    private ControllerInterface getCurrentLevel() {
        return levels.get(current);
    }

    public void levelFinish() {
        changeLevel();
    }

    public void onResume() {
        resume();
    }

    public void onStop() {
        stop();
    }
}
