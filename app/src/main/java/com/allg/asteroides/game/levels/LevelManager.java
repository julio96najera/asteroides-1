package com.allg.asteroides.game.levels;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.allg.asteroides.engine.GameController;
import com.allg.asteroides.engine.GameState;

import java.util.ArrayList;
import java.util.List;

public class LevelManager extends GameController {

    private List<LevelController> levels;
    private int current = 0;

    public LevelManager(Context context) {
        super(context);

        levels = new ArrayList<>();

        levels.add(LevelFactory.createLevel1(context, this));
        levels.add(LevelFactory.createLevel2(context, this));
    }

    private LevelController getCurrentLevel() { return levels.get(current);}

    public void levelFinish() {
        getCurrentLevel().stop();

        current++;

        if (current >= levels.size())
            this.stop();

        getGameState().setState(GameState.State.INTRO);

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
}
