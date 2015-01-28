package com.allg.asteroides.game.levels;

import android.content.Context;

import com.allg.asteroides.game.objects.Background;
import com.allg.asteroides.game.objects.BackgroundMusic;

public abstract class LevelPrototype extends LevelController {


    public LevelPrototype(Context context) {
        super(context);
    }

    public abstract LevelPrototype clone();

}
