package com.allg.asteroides.game.levels;

import android.content.Context;

import com.allg.asteroides.game.objects.background.Fundo1;
import com.allg.asteroides.game.objects.background.Fundo2;
import com.allg.asteroides.game.objects.music.LightYearsMusic;
import com.allg.asteroides.game.objects.SpaceShip;
import com.allg.asteroides.game.objects.abstracts.Background;


public class LevelFactory {

    public static LevelController createLevel1(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo1(context);

        LightYearsMusic music = new LightYearsMusic(context);

        LevelController level =
                new LevelController(context, ship, background, music, 40, 10, manager);

        return level;
    }

    public static LevelController createLevel2(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo2(context);

        LightYearsMusic music = new LightYearsMusic(context);

        LevelController level =
                new LevelController(context, ship, background, music, 100, 20, manager);

        return level;
    }
}
