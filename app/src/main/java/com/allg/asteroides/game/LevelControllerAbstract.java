package com.allg.asteroides.game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;

import com.allg.asteroides.Level2Activity;
import com.allg.asteroides.engine.Collision;
import com.allg.asteroides.engine.GameController;
import com.allg.asteroides.game.objects.Asteroide;
import com.allg.asteroides.game.objects.Background;
import com.allg.asteroides.game.objects.BackgroundMusic;
import com.allg.asteroides.game.objects.Score;
import com.allg.asteroides.game.objects.SpaceShip;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by leandro on 19/01/15.
 */
public abstract class LevelControllerAbstract extends GameController implements SensorEventListener {

    private List<Asteroide> asteroides;
    private Background background;
    private SpaceShip ship;
    private BackgroundMusic music;
    private Score score;

    //Acelerometro
    private SensorManager sensorManager;
    private Sensor accelerometer;

    private int asteroideWait;
    private int asteroideStep = asteroideWait;
    private int numberAsteroides = 0;
    private int asteroidesCreated = 0;

    private boolean levelFinished = false;

    private Activity activity;

    public LevelControllerAbstract(Context context, Background background,
                        BackgroundMusic music, int numberAsteroides, int velocity) {
        super(context);
        this.asteroides = new ArrayList<Asteroide>();
        this.background = background;
        this.ship = new SpaceShip(context, 0, 0);
        this.score = new Score(context, 0, 0, ship);
        this.music = music;

        this.numberAsteroides = numberAsteroides;
        this.asteroideWait = velocity;

        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        activity = (Activity) context;
    }

    private void createAsteroideIfNecessary(Canvas canvas) {

        if (asteroidesCreated <= numberAsteroides) {

            if (asteroideStep >= asteroideWait) {
                Random random = new Random();

                Asteroide asteroide = new Asteroide(getContext(),
                        48 + random.nextInt(canvas.getWidth() - 96), 0);
                asteroides.add(asteroide);

                asteroidesCreated++;
                asteroideStep = 0;
            }

            asteroideStep++;
        }
        else
            levelFinished = true;
    }

    @Override
    public void initObjects(Canvas canvas) {
        ship.initObject(canvas);
        background.initObject(canvas);
        music.initObject(canvas);
        score.initObject(canvas);
    }

    @Override
    public void stepObjects(Canvas canvas) {

        //criando asteroides se estiver na hora
        createAsteroideIfNecessary(canvas);

        //verificando colisão de todos os asteroides com a nave
        for (int i = 0; i < asteroides.size(); ++i) {
            if (Collision.isCollided(asteroides.get(i), ship)) {
                asteroides.remove(i);
                ship.explodir();
            }
        }

        //movimentando asteroides e a nave
        for (int i = 0; i < asteroides.size(); i++)
            asteroides.get(i).step(canvas);

        ship.step(canvas);

        //removendo asteroide, caso ele esteja no fim da tela
        for (int i = 0; i < asteroides.size(); ++i)
            if (asteroides.get(i).isBottom(canvas))
                asteroides.remove(i);

        music.step(canvas);
        score.step(canvas);
    }

    @Override
    public void drawObjects(Canvas canvas) {

        background.draw(canvas);
        score.draw(canvas);

        if (!levelFinished) {
            ship.draw(canvas);
            for (Asteroide a : asteroides) {
                a.draw(canvas);
            }

        } else {
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(60);
            canvas.drawText("Level Finish", (canvas.getWidth() / 2) - 100,
                    canvas.getHeight() / 2, paint);
        }
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.performClick();

        if (levelFinished) {
            Intent intent = new Intent(activity, Level2Activity.class);

            activity.startActivity(intent);
        }

        return super.onTouchEvent(event);
    }

    @Override
    public void resume() {
        super.resume();
        music.startMusic();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void stop() {
        sensorManager.unregisterListener(this);
        music.stopMusic();
        super.stop();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.values[0] > 1)
            ship.irEsquerda();
        else if (event.values[0] < -1)
            ship.irDireita();
        else
            ship.normal();
    }
}
