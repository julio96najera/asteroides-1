package com.allg.asteroides.game.levels;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;

import com.allg.asteroides.R;
import com.allg.asteroides.activity.GameActivity;
import com.allg.asteroides.engine.GameController;
import com.allg.asteroides.engine.GameObject;

/**
 * Created by geovany on 09/04/16.
 */
public class EventLost extends GameObject {

    public Bitmap background;
    public Bitmap text;
    public Bitmap restart;
    public Bitmap sair;
    private Paint paint;

    public int text_y = 0;
    public int bottom = 0;
    public int restart_x = 0;
    public int sair_x = 0;

    public EventLost(Context context) {
        super(context, 0, 0);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.background_event);
        restart = BitmapFactory.decodeResource(getResources(), R.drawable.ic_restart);
        sair = BitmapFactory.decodeResource(getResources(), R.drawable.ic_sair);
    }

    @Override
    public void initObject(Canvas canvas) {

    }

    private void inicializarObjetos(Canvas canvas){
        int grid_y = canvas.getHeight() / 16 ;
        int grid_x = canvas.getWidth() / 8;

        text_y = 5 * grid_y;
        bottom = 11 * grid_y;
        restart_x = 2 * grid_x;
        sair_x = 5 * grid_x;

        paint = new Paint();

        paint.setColor(Color.RED);
        paint.setTextSize(100);
        paint.setTextAlign(Paint.Align.CENTER);

        Typeface plain = Typeface.createFromAsset(getContext().getAssets(), "fonts/starjedi.ttf");
        paint.setTypeface(plain);
    }

    @Override
    public void step(Canvas canvas) {

    }

    public void draw(Canvas canvas) {
        this.inicializarObjetos(canvas);

        drawSprite(canvas, background, 0, 0, (background.getHeight() - canvas.getHeight()));
        canvas.drawText("You Lost", canvas.getWidth() / 2, text_y, paint);

        drawSprite(canvas, restart, restart_x, bottom, 0);
        drawSprite(canvas, sair, sair_x, bottom, 0);
    }

    private void drawSprite(Canvas canvas, Bitmap bitmap, int x, int y, int top){

        Rect src = new Rect(0, top, bitmap.getWidth(), bitmap.getHeight());

        Rect dst = new Rect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());

        canvas.drawBitmap(bitmap, src, dst, null);

    }

    public void touchEvent(MotionEvent event, LevelManager levelManager) {

        if(event.getY() >= this.bottom && event.getY() <= (this.bottom + this.restart.getHeight())){
            if(event.getX() >= this.restart_x && event.getX() <= (this.restart_x + this.restart.getWidth())){
                levelManager.setGameState(GameController.State.INTRO);
            }
        }

        if(event.getY() >= this.bottom && event.getY() <= (this.bottom + this.sair.getHeight())){
            if(event.getX() >= this.sair_x && event.getX() <= (this.sair_x + this.sair.getWidth())){
                levelManager.setGameState(GameController.State.END);
            }
        }
    }
}
