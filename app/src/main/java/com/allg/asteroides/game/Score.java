package com.allg.asteroides.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.allg.asteroides.engine.GameObject;

/**
 * Created by leandro on 21/12/14.
 */
public class Score extends GameObject {

    private int points = 0;

    private Paint paint;

    public Score(Context context, int x, int y) {
        super(context, x, y);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
    }

    @Override
    public void initObject(Canvas canvas) {
        x = canvas.getWidth() - 100;
        y = 60;
    }

    @Override
    public void step(Canvas canvas) {
        //TODO: Sistema de pontuação da nave
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(points+"", x, y, paint);
    }
}
