package br.com.llg.asteroides.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class GameController extends SurfaceView implements Runnable {

	private Thread thread;
	private boolean running;
	private SurfaceHolder holder;

	public GameController(Context context) {
		super(context);
		holder = getHolder();
	}
	
	public abstract void stepObjects(Canvas canvas);
	public abstract void drawObjects(Canvas canvas);
	
	@Override
	public void run() {
		while (running) { //loop do jogo
			if (!holder.getSurface().isValid())
				continue;
			
			Canvas canvas = holder.lockCanvas();
			
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
