package com.allg.asteroides.game.objects.abstracts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.allg.asteroides.engine.GameObject;

public abstract class Background extends GameObject {

    private Bitmap bitmap;

    public Background(Context context) {
        super(context, 0, 0);
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    @Override
    public void initObject(Canvas canvas) {
    }

    @Override
    public void step(Canvas canvas) {
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }

}
