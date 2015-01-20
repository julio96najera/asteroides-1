package com.allg.asteroides.game;

import android.content.Context;

import com.allg.asteroides.game.objects.Background;
import com.allg.asteroides.game.objects.BackgroundMusic;


public class Level1Controller extends LevelControllerAbstract {

    private Background background;
    private BackgroundMusic music;

    private final int velocity = 30;
    private final int numberAsteroides = 50;

    public Level1Controller(Context context) {

        super(context,
                new Background(context, 0, 0),
                new BackgroundMusic(context, true),
                50,
                30);
    }
}
