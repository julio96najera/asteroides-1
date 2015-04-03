package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import com.allg.asteroides.engine.GameObject;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Gun extends GameObject {

    public List<Shot> getShots() {
        return shots;
    }

    private List<Shot> shots;
    private SpaceShip ship;

    public Gun(Context context, SpaceShip ship) {
        super(context, 0, 0);

        shots = new ArrayList<>();
        this.ship = ship;
    }

    @Override
    public void initObject(Canvas canvas) {
    }

    @Override
    public void step(Canvas canvas) {
        for (int i = 0; i < shots.size(); i++) {
            if (shots.get(i).getPosY() < 0)
                shots.remove(i);
            else
                shots.get(i).step(canvas);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        try {
            for (Shot shot : shots) {
                shot.draw(canvas);
            }
        } catch (ConcurrentModificationException e) {
            Log.e("Gun", "Modificação concorrente da lista de tiros, cancelando esse tiro.");
            e.printStackTrace();
        }
    }

    public void disparar() {
        try {
            Shot shot = new Shot(getContext(), ship.getPosX(), ship.getPosY());
            shots.add(shot);
        } catch (ConcurrentModificationException e) {
            Log.e("Gun", "Modificação concorrente da lista de tiros, cancelando esse tiro.");
            e.printStackTrace();
        }
    }
}
