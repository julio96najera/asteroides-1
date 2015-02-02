package com.allg.asteroides.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class GameController extends SurfaceView implements Runnable {

    private static final int INTERVAL = 10;
    private Thread thread;
    private boolean running;
    private SurfaceHolder holder;

    private GameState gameState;

    public GameController(Context context) {
        super(context);
        holder = getHolder();
        gameState = new GameState();
        gameState.setState(GameState.State.INTRO);
    }

    public abstract void initObjects(Canvas canvas);

    public abstract void stepObjects(Canvas canvas);

    public abstract void drawObjects(Canvas canvas);

    public abstract void stepObjectsFinal(Canvas canvas);

    public abstract void drawObjectsFinal(Canvas canvas);

    public abstract void unloadObjects();

    public abstract void touchEvent(MotionEvent event);

    @Override
    public void run() {
        while (running) { //loop do jogo
            if (!holder.getSurface().isValid())
                continue;

            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
            }

            Canvas canvas = holder.lockCanvas();

            if (gameState.getState() == GameState.State.INTRO) {
                this.initObjects(canvas);
                this.gameState.setState(GameState.State.RUNNING);
            }

            if (gameState.getState() == GameState.State.RUNNING) {
                this.stepObjects(canvas);
                this.drawObjects(canvas);
            }

            if (gameState.getState() == GameState.State.END) {
                this.stepObjectsFinal(canvas);
                this.drawObjectsFinal(canvas);
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void resume() {
        running = true;
        this.thread = new Thread(this);
        thread.start();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void stop() {
        running = false;
        unloadObjects();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        touchEvent(event);
        return super.onTouchEvent(event);
    }
}
