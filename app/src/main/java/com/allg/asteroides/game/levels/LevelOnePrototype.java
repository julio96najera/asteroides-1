package com.allg.asteroides.game.levels;

import android.content.Context;

import com.allg.asteroides.game.objects.Background;
import com.allg.asteroides.game.objects.BackgroundMusic;
import com.allg.asteroides.game.objects.Fundo1;

public class LevelOnePrototype extends LevelPrototype {

    public LevelOnePrototype(Context context) {
        super(context);

        this.setBackground(new Fundo1(context));
        this.setMusic(new BackgroundMusic(context, true));
        this.setVelocity(10);
        this.setNumberAsteroides(40);
    }

    @Override
    public LevelPrototype clone() {
        return new LevelOnePrototype(getContext());
    }
}
