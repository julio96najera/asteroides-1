package br.com.llg.asteroides.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import br.com.llg.asteroides.buttons.Left;
import br.com.llg.asteroides.buttons.Right;
import br.com.llg.asteroides.engine.GameController;

public class AsteroidesController extends GameController {

	private List<Asteroide> asteroides;
	private Background background;
	private Left left;
	private Right right;
	private SpaceShip ship;
	
	private static final int WAIT = 70;
	private int stepCount = 0;
	
	public AsteroidesController(Context context) {
		super(context);
		asteroides = new ArrayList<Asteroide>();
		background = new Background(context, 0, 0);
		ship = new SpaceShip(context, 0, 0);
		left = new Left(context, 0, 0, ship);
		right = new Right(context, 0, 0, ship);
	}

	@Override
	public void stepObjects(Canvas canvas) {
		
		ship.step(canvas);

		stepCount++;
		if (stepCount >= WAIT) {
			
			Random random = new Random();

			Asteroide asteroide = new Asteroide(getContext(), 
					48 + random.nextInt(canvas.getWidth()-96), 0);
			asteroides.add(asteroide);
			
			stepCount = 0;
		}
		
		//não vou usar for-each loop porque eu vou alterar os itens da lista (no caso, deletar-los)
		for (int i = 0; i < asteroides.size(); i++) {
			
			asteroides.get(i).step(canvas);
			
			if (asteroides.get(i).isBottom(canvas)) {
				asteroides.remove(i);
			}
		}

		//TODO: Verificar Colisao
		
		left.step(canvas);
		right.step(canvas);
	}

	@Override
	public void drawObjects(Canvas canvas) {
		
		background.draw(canvas);		
		ship.draw(canvas);
		left.draw(canvas);
		right.draw(canvas);
		for (Asteroide a : asteroides) {
			a.draw(canvas);
		}
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		left.onTouchEvent(event);
		right.onTouchEvent(event);
		return super.onTouchEvent(event);
	}
	
	

}
