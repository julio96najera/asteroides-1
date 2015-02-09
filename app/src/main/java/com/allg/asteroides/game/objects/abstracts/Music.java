package com.allg.asteroides.game.objects.abstracts;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;

import com.allg.asteroides.engine.GameObject;

public class Music extends GameObject {

    private MediaPlayer player;
    private boolean startAutomatic = true;

    public Music(Context context, boolean startAutomatic, int resourceid) {
        super(context, 0, 0);
        this.startAutomatic = startAutomatic;
        player = MediaPlayer.create(context, resourceid);
    }

    @Override
    public void initObject(Canvas canvas) {
        if (startAutomatic)
            this.startMusic();
    }

    @Override
    public void step(Canvas canvas) {
    }

    @Override
    public void draw(Canvas canvas) {
    }

    public void startMusic() {
        if (!player.isPlaying()) {
            player.start();
        }
    }

    public void stopMusic() {
        if (player.isPlaying()) {
            player.stop();
            player.release();
        }

    }
}
