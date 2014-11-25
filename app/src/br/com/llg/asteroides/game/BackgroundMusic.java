package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Canvas;
import android.media.MediaPlayer;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;

/**
 * Created by leandro on 25/11/14.
 */
public class BackgroundMusic extends GameObject {

    private MediaPlayer player;
    private boolean startAutomatic = true;

    public BackgroundMusic(Context context, int x, int y, boolean startAutomatic) {
        super(context, x, y);
        player = MediaPlayer.create(context, R.raw.light_years);
        this.startAutomatic = startAutomatic;
    }

    @Override
    public void initObject(Canvas canvas) {
        if (!player.isPlaying() && startAutomatic) {
            player.start();
        }

    }

    @Override
    public void step(Canvas canvas) {
        startMusic(); //inicia a musica caso ela tenha parado
    }

    @Override
    public void draw(Canvas canvas) {}

    public void startMusic() {
        if (!player.isPlaying()) {
            player.start();
        }
    }
    public void stopMusic() {
        if (player.isPlaying())
            player.stop();
    }
}
