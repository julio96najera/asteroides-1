package com.allg.asteroides.game.objects.abstracts;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;

import com.allg.asteroides.engine.GameObject;

public class Sound extends GameObject {

    private MediaPlayer player;

    public Sound(Context context, int resouceid) {
        super(context, 0, 0);
        player = MediaPlayer.create(context, resouceid);
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
