package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;
import com.allg.asteroides.engine.Sprite;
import com.allg.asteroides.game.objects.sound.ExplosionSound;

public class Asteroid extends GameObject {

    private static final int EXPLOSION_WAIT = 5;
    private static final int MAX_SPRITES = 5;

    private Bitmap bitmap;
    private int passoY;

    private boolean exploded = false;
    private ExplosionSound explosionSound;
    private boolean explosionSoundFinish = false;
    private Sprite explosionSprite;
    private int explosionWaitCount = 0;
    private int explosionAnimCount = 0;

    public Asteroid(Context context, int x, int y, int velocity) {
        super(context, x, y);
        this.x = x;
        this.y = y;

        //instanciar bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.asteroide);
        this.height = bitmap.getHeight();
        this.width = bitmap.getWidth();

        this.passoY = velocity;

        this.explosionSprite = new Sprite(
                BitmapFactory.decodeResource(getResources(), R.drawable.explosion),
                1, 5, this);
        explosionSound = new ExplosionSound(context);
    }

    @Override
    public void initObject(Canvas canvas) {

    }

    @Override
    public void step(Canvas canvas) {
        y += passoY;

        if (exploded)
            if (!explosionSoundFinish) {
                explosionSound.startSound();
                explosionSoundFinish = true;
            }
    }

    @Override
    public void draw(Canvas canvas) {
        if (exploded) {

            if (explosionWaitCount >= EXPLOSION_WAIT) {
                explosionWaitCount = 0;
                explosionAnimCount++; //passa para o proximo sprite
            }

            if (explosionAnimCount <= MAX_SPRITES)
                explosionSprite.draw(canvas, 0, explosionAnimCount);

            explosionWaitCount++;
        } else {
            canvas.drawBitmap(bitmap, x, y, null);
        }
    }

    public boolean isBottom(Canvas canvas) {
        return this.getPosY() > canvas.getHeight();
    }

    public void explodir() {
        exploded = true;
    }

    public boolean isExploded() {
        return exploded;
    }
}
