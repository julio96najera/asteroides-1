package com.allg.asteroides.game;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;


public class ExplosionSound extends GameObject {

    private MediaPlayer player;

    public ExplosionSound(Context context, int x, int y) {
        super(context, x, y);
        player = MediaPlayer.create(context, R.raw.explosion);
    }

    @Override
    public void initObject(Canvas canvas) {
    }

    @Override
    public void step(Canvas canvas) {
    }

    @Override
    public void draw(Canvas canvas) {
    }

    public void startSound() {
        if (!player.isPlaying()) {
            player.start();
        }
    }
}
