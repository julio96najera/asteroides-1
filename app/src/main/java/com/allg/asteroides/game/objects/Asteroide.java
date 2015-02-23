package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;
import com.allg.asteroides.engine.Sprite;
import com.allg.asteroides.game.objects.sound.ExplosionSound;

public class Asteroide extends GameObject {

    private Bitmap bitmap;
    private int passoY;

    private boolean exploded = false;
    private ExplosionSound explosionSound;
    private boolean explosionSoundFinish = false;
    private Sprite explosionSprite;
    private Boolean explosion = false;
    private int explosionWait = 5;
    private int explosionWaitCount = 0;
    private int explosionAnimCount = 0;
    private Bitmap explosionBitmap;

    public Asteroide(Context context, int x, int y, int velocity) {
        super(context, x, y);
        this.x = x;
        this.y = y;

        //instanciar bitmap
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.asteroide);
        this.height = bitmap.getHeight();
        this.width = bitmap.getWidth();

        this.passoY = velocity;

        explosionBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.explosion);
        this.explosionSprite = new Sprite(explosionBitmap, 1, 5, this);
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

            if (explosionWaitCount >= explosionWait) {
                explosionWaitCount = 0;
                explosionAnimCount++; //passa para o proximo sprite
            }

            explosionSprite.draw(canvas, 0, explosionAnimCount);

            explosionWaitCount++;
        } else {
            canvas.drawBitmap(bitmap, x, y, null);
        }
    }

    public boolean isBottom(Canvas canvas) {

        if (this.getPosY() > canvas.getHeight())
            return true;

        return false;
    }

    public void explodir() {
        exploded = true;
    }
}
