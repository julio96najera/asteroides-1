package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;

public class Shot extends GameObject {

    private Bitmap bitmap;

    public Shot(Context context, int x, int y) {
        super(context, x, y);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shot);

        width = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    @Override
    public void initObject(Canvas canvas) {

    }

    @Override
    public void step(Canvas canvas) {
        y -= 5;
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap, x, y, null);
    }
}

