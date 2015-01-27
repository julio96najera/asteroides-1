package com.allg.asteroides.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class GameController extends SurfaceView implements Runnable {

	private Thread thread;
	private boolean running;
	private SurfaceHolder holder;
	private static final int INTERVAL = 10;
	private boolean firstInteract = false;

	public GameController(Context context) {
        super(context);
        holder = getHolder();
    }
	
	public abstract void initObjects(Canvas canvas);
	public abstract void stepObjects(Canvas canvas);
	public abstract void drawObjects(Canvas canvas);

	@Override
	public void run() {
		while (running) { //loop do jogo
			if (!holder.getSurface().isValid())
				continue;
			
			try {
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {}

			Canvas canvas = holder.lockCanvas();
			
			if (!firstInteract) {
				initObjects(canvas);
				firstInteract = true;
			}
				
			this.stepObjects(canvas);
			this.drawObjects(canvas);
			
			holder.unlockCanvasAndPost(canvas);
        }
	}
	
	public void resume() {
		running = true;
		this.thread = new Thread(this);
		thread.start();
	}
	
	public void stop() {
		running = false;
	}

}
