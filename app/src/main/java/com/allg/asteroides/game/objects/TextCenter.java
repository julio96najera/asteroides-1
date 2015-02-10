package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.allg.asteroides.engine.GameObject;

public class TextCenter extends GameObject {

    private String text;
    private Paint textPaint;

    public TextCenter(Context context, String text, int fontSize, int color) {
        super(context, 0, 0);
        this.text = text;
        this.textPaint = new Paint();
        this.textPaint.setColor(color);
        this.textPaint.setTextSize(fontSize);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void initObject(Canvas canvas) {
        x = (canvas.getWidth() / 2);
        y = (int) ((canvas.getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2)) ;
    }

    @Override
    public void step(Canvas canvas) {

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawText(text, x, y, textPaint);
    }
}
