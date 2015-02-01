package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.allg.asteroides.R;

public class Fundo2 extends Background {

    private Bitmap bitmap;

    public Fundo2(Context context) {
        super(context);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fundoestrelado);
        setBitmap(bitmap);
    }
}
