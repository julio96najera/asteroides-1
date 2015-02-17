package com.allg.asteroides.game.objects.abstracts;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.allg.asteroides.engine.GameObject;

public abstract class Background extends GameObject {

    private Bitmap bitmap;
    private BitmapFactory.Options options;
    private int top = 0;
    private int bottom = 0;
    private int passeY = 5;

    public Background(Context context, int resourceid) {
        super(context, 0, 0);

        options = new BitmapFactory.Options();
        bitmap = BitmapFactory.decodeResource(getResources(), resourceid, options);
    }

    @Override
    public void initObject(Canvas canvas) {
        bottom = bitmap.getHeight();
        top = bitmap.getHeight() - canvas.getHeight();
    }

    @Override
    public void step(Canvas canvas) {

        if(top <= 0){
            initObject(canvas);
        }
        else {
            bottom -= passeY;
            top -= passeY;
        }
    }

    @Override
    public void draw(Canvas canvas) {

        Rect src = new Rect(0, top, canvas.getWidth(), bottom);

        Rect dst = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());

        canvas.drawBitmap(bitmap, src, dst, null);
    }

}