package com.allg.asteroides.game.objects.music;

import android.content.Context;

import com.allg.asteroides.R;
import com.allg.asteroides.game.objects.abstracts.Music;

public class CopShowMusic extends Music {
    public CopShowMusic(Context context, boolean startAutomatic) {
        super(context, startAutomatic, R.raw.cop_show_2085);

        //Source: http://soundimage.org/sci-fi/
    }
}
