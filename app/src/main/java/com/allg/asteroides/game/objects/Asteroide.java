package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;

public class Asteroide extends GameObject {

    private Bitmap bitmap;
    private int passoY;

    public Asteroide(Context context, int x, int y, int velocity) {
        super(context, x, y);
        this.x = x;
        this.y = y;

        //instanciar bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.asteroide);
        this.height = bitmap.getHeight();
        this.width = bitmap.getWidth();

        this.passoY = velocity;
    }

    @Override
    public void initObject(Canvas canvas) {

    }

    @Override
    public void step(Canvas canvas) {
        y += passoY;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }

    public boolean isBottom(Canvas canvas) {

        if (y >= canvas.getHeight())
            return true;

        return false;
    }

    public void explodir() {

    }

}
