package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.allg.asteroides.R;
import com.allg.asteroides.game.objects.abstracts.Background;

public class Fundo1 extends Background {

    private Bitmap bitmap;

    public Fundo1(Context context) {
        super(context);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        this.setBitmap(bitmap);
    }
}
