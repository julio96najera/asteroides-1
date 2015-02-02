package com.allg.asteroides.game.objects.sound;

import android.content.Context;

import com.allg.asteroides.R;
import com.allg.asteroides.game.objects.abstracts.Sound;


public class ExplosionSound extends Sound {


    public ExplosionSound(Context context) {
        super(context, R.raw.explosion);
    }
}
