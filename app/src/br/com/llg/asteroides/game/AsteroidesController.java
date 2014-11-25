package br.com.llg.asteroides.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.MotionEvent;
import br.com.llg.asteroides.engine.Collision;
import br.com.llg.asteroides.engine.GameController;

public class AsteroidesController extends GameController implements SensorEventListener {

	private List<Asteroide> asteroides;
	private Background background;
	private SpaceShip ship;
    private BackgroundMusic backgroundMusic;

	private static final int asteroideWait = 30;
	private int asteroideStep = asteroideWait;

	private SensorManager sensorManager;
	private Sensor accelerometer;

	public AsteroidesController(Context context) {
		super(context);
		asteroides = new ArrayList<Asteroide>();
		background = new Background(context, 0, 0);
		ship = new SpaceShip(context, 0, 0);
        backgroundMusic = new BackgroundMusic(context, 0, 0, true);

		sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}

	@Override
	public void initObjects(Canvas canvas) {
		ship.initObject(canvas);
		background.initObject(canvas);
        backgroundMusic.initObject(canvas);
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

        backgroundMusic.step(canvas);
	}

	private void createAsteroideIfNecessary(Canvas canvas) {
		
		if (asteroideStep >= asteroideWait) {
			Random random = new Random();

			Asteroide asteroide = new Asteroide(getContext(), 
					48 + random.nextInt(canvas.getWidth()-96), 0);
			asteroides.add(asteroide);

			asteroideStep = 0;
		}

		asteroideStep++;
	}

	@Override
	public void drawObjects(Canvas canvas) {

		background.draw(canvas);		
		ship.draw(canvas);
		for (Asteroide a : asteroides) {
			a.draw(canvas);
		}

	}

	@Override
	public boolean performClick() {
		return super.performClick();
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.performClick();
		return super.onTouchEvent(event);
	}

	@Override
	public void resume() {
		super.resume();
        backgroundMusic.startMusic();
		sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void stop() {
		sensorManager.unregisterListener(this);
		backgroundMusic.stopMusic();
		super.stop();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

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
