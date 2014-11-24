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

	private static final int WAIT = 10;
	private int stepCount = 0;
	private static final int asteroideWait = 20;
	private int asteroideStep = 0;
	
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

		stepCount++;
		if (stepCount >= WAIT) {

			ship.step(canvas);

			asteroideStep++;
			if (asteroideStep >= asteroideWait) {
				Random random = new Random();

				Asteroide asteroide = new Asteroide(getContext(), 
						48 + random.nextInt(canvas.getWidth()-96), 0);
				asteroides.add(asteroide);

				asteroideStep = 0;
			}

			for (int i = 0; i < asteroides.size(); i++) {

				asteroides.get(i).step(canvas);
				
				if (asteroides.get(i).isBottom(canvas)) {
					asteroides.remove(i);
				}
				
				if (Collision.isCollided(ship, asteroides.get(i))) {
					ship.explodir();
					asteroides.get(i).explodir();
				}
			}
			
			stepCount = 0;
		}
		
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
}
