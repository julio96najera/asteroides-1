package com.allg.asteroides.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.allg.asteroides.game.objects.SpaceShip;

/**
 * Objeto responsável por controlar os movimentos da nave. Ela observa os sensores e diz a nave o que fazer.
 */
public class SpaceShipControl implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private SpaceShip ship;

    public SpaceShipControl(Context context, SpaceShip ship) {
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        this.ship = ship;

    }

    public void startControl() {
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
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

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
