package com.allg.asteroides.game.levels;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

import com.allg.asteroides.engine.Collision;
import com.allg.asteroides.engine.GameController;
import com.allg.asteroides.engine.GameState;
import com.allg.asteroides.game.objects.Asteroide;
import com.allg.asteroides.game.objects.AsteroideManager;
import com.allg.asteroides.game.objects.Score;
import com.allg.asteroides.game.objects.SpaceShip;
import com.allg.asteroides.game.objects.abstracts.Background;
import com.allg.asteroides.game.objects.abstracts.Music;
import com.allg.asteroides.util.SpaceShipControl;

public class LevelController extends GameController {

    private SpaceShip ship;
    private SpaceShipControl shipControl;
    private Score score;

    private Background background;

    private AsteroideManager asteroideManager;

    private Music music;

    private LevelManager levelManager;

    private boolean playerWin = false;

    public LevelController(Context context, SpaceShip ship, Background background,
                           Music music, int asteroidesNumber, int velocity,
                           LevelManager levelManager) {

        super(context);
        this.ship = ship;
        this.shipControl = new SpaceShipControl(context, ship);

        this.background = background;

        this.score = new Score(context, ship);

        this.asteroideManager = new AsteroideManager(context, asteroidesNumber, velocity);

        this.music = music;

        this.levelManager = levelManager;
    }

    @Override
    public void initObjects(Canvas canvas) {
        ship.initObject(canvas);
        shipControl.startControl();
        background.initObject(canvas);
        score.initObject(canvas);
        asteroideManager.initObject(canvas);
        music.initObject(canvas);
    }

    @Override
    public void stepObjects(Canvas canvas) {
        ship.step(canvas);
        score.step(canvas);
        asteroideManager.step(canvas);

        for (Asteroide a : asteroideManager.getAsteroides()) {
            if (Collision.isCollided(a, ship)) {
                ship.explodir();
                getGameState().setState(GameState.State.END);
                playerWin = false;
            }
        }

        if (asteroideManager.isAllAsteroidesCreated() && !ship.isExploded()) {
            playerWin = true;
        }

    }

    @Override
    public void drawObjects(Canvas canvas) {
        background.draw(canvas);
        ship.draw(canvas);
        score.draw(canvas);
        asteroideManager.draw(canvas);

    }

    @Override
    public void stepObjectsFinal(Canvas canvas) {
        ship.step(canvas);
    }

    @Override
    public void drawObjectsFinal(Canvas canvas) {
        background.draw(canvas);
        score.draw(canvas);
        ship.draw(canvas);

        if (playerWin) {
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            canvas.drawText("Você venceu! Toque na tela.", 50, canvas.getHeight() / 2, paint);
        }
    }

    @Override
    public void unloadObjects() {
        music.stopMusic();
    }

    @Override
    public void touchEvent(MotionEvent event) {
        if (getGameState().getState() == GameState.State.END && playerWin) {
            levelManager.levelFinish();
        }
    }
}
