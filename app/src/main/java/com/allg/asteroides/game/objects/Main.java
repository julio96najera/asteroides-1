package com.allg.asteroides.game.objects;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.allg.asteroides.R;
import com.allg.asteroides.engine.GameObject;

/**
 * Created by geovany on 04/03/15.
 */
public class Main extends GameObject{

    public Bitmap background;
    public Bitmap creditos;
    public Bitmap start;
    public Bitmap opcoes;

    public int x = 0;

    public int start_y;
    public int opcoes_y;
    public int creditos_y;
    public int espaco;


    public Main(Context context) {
        super(context, 0, 0);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.background_menu);
        start = BitmapFactory.decodeResource(getResources(), R.drawable.start);
        opcoes = BitmapFactory.decodeResource(getResources(), R.drawable.opcoes);
        creditos = BitmapFactory.decodeResource(getResources(), R.drawable.creditos);

    }

    @Override
    public void initObject(Canvas canvas) {

    }

    @Override
    public void step(Canvas canvas) {

    }

    public void draw(Canvas canvas) {

        espaco = start.getHeight();

        x = (canvas.getWidth() / 2) - (start.getWidth() / 2);

        start_y = (canvas.getHeight() / 3);
        opcoes_y = start_y + espaco;
        creditos_y = opcoes_y + espaco;

        drawSprite(canvas, background, 0, 0, (background.getHeight() - canvas.getHeight()));
        drawSprite(canvas, start, x, start_y, 0);
        drawSprite(canvas, opcoes, x, opcoes_y, 0);
        drawSprite(canvas, creditos, x, creditos_y, 0);
    }

    private void drawSprite(Canvas canvas, Bitmap bitmap, int x, int y, int top){

        Rect src = new Rect(0, top, bitmap.getWidth(), bitmap.getHeight());

        Rect dst = new Rect(x, y, x + bitmap.getWidth(), y + bitmap.getHeight());

        canvas.drawBitmap(bitmap, src, dst, null);

    }
}
