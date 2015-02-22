package com.allg.asteroides.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class GameController extends SurfaceView implements Runnable, ControllerInterface {

    private static final int INTERVAL = 10;
    private Thread thread;
    private boolean running;
    private SurfaceHolder holder;

    public enum State {
        INTRO,
        RUNNING,
        END
    }

    private State gameState;

    public GameController(Context context) {
        super(context);
        holder = getHolder();
        gameState = State.INTRO;
    }

    @Override
    public synchronized void run() {
        while (running) { //loop do jogo
            if (!holder.getSurface().isValid())
                continue;

            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
            }

            Canvas canvas = holder.lockCanvas();

            if (gameState == State.INTRO) {
                this.initObjects(canvas);
                this.gameState = State.RUNNING;
            }

            if (gameState == State.RUNNING) {
                this.stepObjects(canvas);
                this.drawObjects(canvas);
            }

            if (gameState == State.END) {
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

    public void stop() {
        running = false;
        unloadObjects();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        touchEvent(event);
        return super.onTouchEvent(event);
    }

    public State getGameState() {
        return gameState;
    }

    public void setGameState(State gameState) {
        this.gameState = gameState;
    }
}
