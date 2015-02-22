package com.allg.asteroides.game.levels;

import android.content.Context;

import com.allg.asteroides.game.objects.background.Fundo1;
import com.allg.asteroides.game.objects.background.Fundo2;
import com.allg.asteroides.game.objects.music.CopShowMusic;
import com.allg.asteroides.game.objects.music.DigitalFalloutMusic;
import com.allg.asteroides.game.objects.music.LightYearsMusic;
import com.allg.asteroides.game.objects.SpaceShip;
import com.allg.asteroides.game.objects.abstracts.Background;


public class LevelFactory {

    private static int quantityOfAsteroids;
    private static int velocity;

    public static AsteroidesLevelController createLevel1(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo1(context);

        LightYearsMusic music = new LightYearsMusic(context, true);

        quantityOfAsteroids = 20;
        velocity = 10;

        AsteroidesLevelController level =
                new AsteroidesLevelController(context, ship, background, music, quantityOfAsteroids, velocity, manager);

        return level;
    }

    public static AsteroidesLevelController createLevel2(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo2(context);

        DigitalFalloutMusic music = new DigitalFalloutMusic(context, true);

        quantityOfAsteroids = 40;
        velocity = 15;

        AsteroidesLevelController level =
                new AsteroidesLevelController(context, ship, background, music, quantityOfAsteroids, velocity, manager);

        return level;
    }

    public static AsteroidesLevelController createLevel3(Context context, LevelManager manager) {

        SpaceShip ship = new SpaceShip(context, 0, 0);

        Background background = new Fundo2(context);

        CopShowMusic music = new CopShowMusic(context, true);

        quantityOfAsteroids = 80;
        velocity = 20;

        AsteroidesLevelController level =
                new AsteroidesLevelController(context, ship, background, music, quantityOfAsteroids, velocity, manager);

        return level;
    }
}
