package com.allg.asteroides.game.levels;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;

import com.allg.asteroides.engine.GameController;
import com.allg.asteroides.engine.GameManager;
import com.allg.asteroides.engine.GameState;

import java.util.ArrayList;
import java.util.List;

public class LevelManager extends GameManager {

    public LevelManager(Context context) {
        super(context);

        //adicionando os níveis para lista levels herdada por protected de GameManager
        levels.add(LevelFactory.createLevel1(context, this));
        levels.add(LevelFactory.createLevel2(context, this));
    }
}
