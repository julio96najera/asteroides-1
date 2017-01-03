package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Canvas;

import com.allg.asteroides.engine.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AsteroidManager extends GameObject {

    private List<Asteroid> asteroids;

    private int asteroidesQuantity;
    private int velocity;
    private int creationInterval; //interações por criação de asteroide

    private int creationSteps = 0;
    private int asteroidesOutOfDisplay;

    public AsteroidManager(Context context, int asteroidesQuantity, int velocity) {
        super(context, 0, 0);

        this.asteroids = new ArrayList<>();
        this.asteroidesQuantity = asteroidesQuantity;
        this.velocity = velocity;

        this.creationInterval = 40;
    }

    public List<Asteroid> getAsteroids() {
        return asteroids;
    }

    @Override
    public void initObject(Canvas canvas) {

    }

    @Override
    public void step(Canvas canvas) {
        createAsteroide(canvas);

        asteroidesOutOfDisplay = 0;

        for (Asteroid a : asteroids) {
            if (a.isBottom(canvas))
                asteroidesOutOfDisplay++;
            else
                a.step(canvas);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (Asteroid a : asteroids)
            if (!a.isBottom(canvas))
                a.draw(canvas);
    }

    private void createAsteroide(Canvas canvas) {
        if (asteroids.size() < asteroidesQuantity) {

            if (creationSteps >= creationInterval) {
                Random random = new Random();

                Asteroid asteroid = new Asteroid(getContext(),
                        48 + random.nextInt(canvas.getWidth() - 96), 0, velocity);
                asteroids.add(asteroid);

                creationSteps = 0;

                if (creationInterval > 30)
                    creationInterval--;
            }

            creationSteps++;
        }

    }

    public boolean isAllAsteroidesCreated() {
        return (asteroidesOutOfDisplay >= asteroidesQuantity);
    }
}
