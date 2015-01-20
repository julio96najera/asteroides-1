package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.allg.asteroides.engine.GameObject;

public class Score extends GameObject {

    private int points = 0;
    private Paint paint;
    private SpaceShip ship;

    public Score(Context context, int x, int y, SpaceShip ship) {
        super(context, x, y);

        this.ship = ship;

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

        if (ship.getDistance() % 20 == 0) {
            points++;
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(points+"", x, y, paint);
    }
}
