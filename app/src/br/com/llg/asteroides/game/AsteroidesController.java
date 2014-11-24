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

	private static final int asteroideWait = 20;
	private int asteroideStep = asteroideWait;

	private SensorManager sensorManager;
	private Sensor accelerometer;

	public AsteroidesController(Context context) {
		super(context);
		asteroides = new ArrayList<Asteroide>();
		background = new Background(context, 0, 0);
		ship = new SpaceShip(context, 0, 0);

		sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
		accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}

	@Override
	public void stepObjects(Canvas canvas) {

		createAsteroideIfNecessary(canvas);


		for (int i = 0; i < asteroides.size(); ++i) {
			if (Collision.isCollided(asteroides.get(i), ship)) {
				asteroides.remove(i);
				ship.explodir();
			}
		}

		for (int i = 0; i < asteroides.size(); i++)
			asteroides.get(i).step(canvas);
		
		ship.step(canvas);

		for (int i = 0; i < asteroides.size(); ++i)
			if (asteroides.get(i).isBottom(canvas))
				asteroides.remove(i);		
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
		sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}

	@Override
	public void stop() {
		sensorManager.unregisterListener(this);
		super.stop();
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {}

	@Override
	public void onSensorChanged(SensorEvent event) {

		if (event.values[0] > 2)
			ship.irEsquerda();
		else if (event.values[0] < -2)
			ship.irDireita();
		else
			ship.normal();
	}

	@Override
	public void initObjects(Canvas canvas) {
		// TODO Auto-generated method stub
		
	}
}
