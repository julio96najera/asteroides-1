package com.allg.asteroides.engine;

import android.graphics.Canvas;
import android.view.MotionEvent;

/**
 * Created by leandro on 20/02/15.
 */
public interface ControllerInterface {

    public void initObjects(Canvas canvas);

    public void stepObjects(Canvas canvas);

    public void drawObjects(Canvas canvas);

    public void stepObjectsFinal(Canvas canvas);

    public void drawObjectsFinal(Canvas canvas);

    public void unloadObjects();

    public void touchEvent(MotionEvent event);
}
