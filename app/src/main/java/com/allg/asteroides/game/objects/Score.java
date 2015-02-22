package com.allg.asteroides.game.objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.allg.asteroides.engine.GameObject;

public class Score extends GameObject {

    private int points = 0;
    private Paint paint;
    private SpaceShip ship;
    private HighScore hScore;

    public final String PREFS_NAME = "Score";
    private final String KEY = "scoreCache";
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor prefsPrivateEditor;

    public Score(Context context, SpaceShip ship) {
        super(context, 0, 0);

        this.ship = ship;

        hScore = new HighScore(context);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
    }

    @Override
    public void initObject(Canvas canvas) {
        hScore.initObject(canvas);
        x = canvas.getWidth() - 100;
        y = 60;

        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefsPrivateEditor = sharedPreferences.edit();

        points = sharedPreferences.getInt(KEY, 0);
    }

    @Override
    public void step(Canvas canvas) {
        //TODO: Sistema de pontuação da nave

        if (ship.getDistance() % 20 == 0) {
            points++;
        }

        if(points > hScore.highScore){
            int score = points;

            hScore.saveHighScore(score);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(points + "", x, y, paint);
        hScore.draw(canvas);
    }

    public void saveCacheScore() {
        prefsPrivateEditor.putInt(KEY, points);
        prefsPrivateEditor.commit();
    }

    public void clearCacheScore() {
        prefsPrivateEditor.putInt(KEY, 0);
        prefsPrivateEditor.commit();
    }
}
