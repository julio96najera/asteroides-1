package com.allg.asteroides.game.levels;

import android.content.Context;

import com.allg.asteroides.game.objects.background.Fundo1;
import com.allg.asteroides.game.objects.background.Fundo2;
import com.allg.asteroides.game.objects.music.LightYearsMusic;
import com.allg.asteroides.game.objects.SpaceShip;
import com.allg.asteroides.game.objects.abstracts.Background;


public class LevelFactory {

    public static AsteroidesLevelController createLevel1(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo1(context);

        LightYearsMusic music = new LightYearsMusic(context);

        AsteroidesLevelController level =
                new AsteroidesLevelController(context, ship, background, music, 10, 10, manager);

        return level;
    }

    public static AsteroidesLevelController createLevel2(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo2(context);

        LightYearsMusic music = new LightYearsMusic(context);

        AsteroidesLevelController level =
                new AsteroidesLevelController(context, ship, background, music, 50, 20, manager);

        return level;
    }
}
