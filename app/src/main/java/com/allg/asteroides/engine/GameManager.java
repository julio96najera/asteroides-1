package com.allg.asteroides.engine;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.allg.asteroides.game.levels.LevelController;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    protected List<LevelController> levels;
    private LevelController currentLevel;
    private int current = 0;

    private Activity activity;

    public GameManager(Context context) {
        levels = new ArrayList<>();

        this.activity = (Activity) context;
    }

    private synchronized void changeLevel() {
        currentLevel.stop();

        current = ++current % levels.size();
        Log.d("GameManager", "Troca de Nível: current == "+current);

        currentLevel = levels.get(current);

        activity.setContentView(currentLevel);

        currentLevel.resume();
    }

    public void levelFinish() {
        changeLevel();
    }

    public void onCreate() {
        currentLevel = levels.get(current);
        activity.setContentView(currentLevel);
    }

    public void onResume() {
        currentLevel.resume();
    }

    public void onStop() {
        currentLevel.stop();
    }
}
