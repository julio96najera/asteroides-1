package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import com.allg.asteroides.engine.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AsteroideManager extends GameObject {

    private List<Asteroide> asteroides;

    private int asteroidesQuantity;
    private int velocity;
    private int creationInterval; //interações por criação de asteroide

    private int creationSteps = 0;
    private int asteroidesOutOfDisplay;

    public AsteroideManager(Context context, int asteroidesQuantity, int velocity) {
        super(context, 0, 0);

        this.asteroides = new ArrayList<>();
        this.asteroidesQuantity = asteroidesQuantity;
        this.velocity = velocity;

        this.creationInterval = 40;
    }

    public List<Asteroide> getAsteroides() {
        return asteroides;
    }

    @Override
    public void initObject(Canvas canvas) {

    }

    @Override
    public void step(Canvas canvas) {
        createAsteroide(canvas);

        asteroidesOutOfDisplay = 0;

        for (Asteroide a : asteroides) {
            if (a.isBottom(canvas))
                asteroidesOutOfDisplay++;
            else
                a.step(canvas);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        for (Asteroide a : asteroides)
            if (!a.isBottom(canvas))
                a.draw(canvas);
    }

    private void createAsteroide(Canvas canvas) {
        if (asteroides.size() < asteroidesQuantity) {

            if (creationSteps >= creationInterval) {
                Random random = new Random();

                Asteroide asteroide = new Asteroide(getContext(),
                        48 + random.nextInt(canvas.getWidth() - 96), 0, velocity);
                asteroides.add(asteroide);

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
