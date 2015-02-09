package com.allg.asteroides.game.objects;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.allg.asteroides.engine.GameObject;

/**
 * Created by geovany on 07-02-2015.
 */
public class HighScore extends GameObject{
    public final String PREFS_NAME = "HighScore";
    private SharedPreferences sharedPreferences;

    private Paint paint;
    int highScore;

    public HighScore(Context context) {
        super(context, 0, 0);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
    }

    @Override
    public void initObject(Canvas canvas) {
        x = canvas.getWidth() - 200;
        y = 60;
    }

    public void saveHighScore(int score){
        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsPrivateEditor = sharedPreferences.edit();

        prefsPrivateEditor.putInt("score", score);
        prefsPrivateEditor.commit();
    }

    @Override
    public void step(Canvas canvas) {

    }

    @Override
    public void draw(Canvas canvas) {
        sharedPreferences = getContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        highScore = sharedPreferences.getInt("score", 0);
        canvas.drawText(highScore + "", x, y, paint);
    }
}
