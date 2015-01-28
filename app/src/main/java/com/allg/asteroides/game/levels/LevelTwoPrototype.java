package com.allg.asteroides.game.levels;

import android.content.Context;

import com.allg.asteroides.GameActivity;
import com.allg.asteroides.game.objects.BackgroundMusic;
import com.allg.asteroides.game.objects.Fundo2;

public class LevelTwoPrototype extends LevelPrototype {

    public LevelTwoPrototype(Context context) {
        super(context);

        setBackground(new Fundo2(context));
        setMusic(new BackgroundMusic(context, false));
        setNumberAsteroides(100);
        setVelocity(30);
    }

    @Override
    public LevelPrototype clone() {
        return new LevelTwoPrototype(getContext());
    }
}
