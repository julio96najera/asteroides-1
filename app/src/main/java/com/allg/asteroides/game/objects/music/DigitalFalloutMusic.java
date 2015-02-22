package com.allg.asteroides.game.objects.music;

import android.content.Context;

import com.allg.asteroides.R;
import com.allg.asteroides.game.objects.abstracts.Music;

public class DigitalFalloutMusic extends Music {

    public DigitalFalloutMusic(Context context, boolean startAutomatic) {
        super(context, startAutomatic, R.raw.digital_fallout);

        //Source: http://soundimage.org/sci-fi/
    }
}
