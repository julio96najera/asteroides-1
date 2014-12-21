package com.allg.asteroides.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;

public class Background extends GameObject {

    private Bitmap bitmap;

    public Background(Context context, int x, int y) {
        super(context, x, y);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
    }

    @Override
    public void initObject(Canvas canvas) {
    }

    @Override
    public void step(Canvas canvas) {
/*        y++;

        if (y + bitmap.getHeight() > canvas.getHeight()) {
            x = 0;
            y = 0;
        }*/
    }

    @Override
    public void draw(Canvas canvas) {

//        Rect rectSrc = new Rect(x, y, x+canvas.getHeight(), y+canvas.getWidth());
//
//        Rect rectDst = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
//
//        canvas.drawBitmap(bitmap, rectSrc, rectDst, null);

        canvas.drawBitmap(bitmap, x, y, null);
    }

}
