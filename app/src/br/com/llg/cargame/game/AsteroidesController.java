package br.com.llg.cargame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Canvas;
import br.com.llg.cargame.engine.GameController;

public class AsteroidesController extends GameController {

	private List<Asteroide> asteroides;
	private Background background;
	
	private static final int WAIT = 70;
	private int stepCount = 0;
	
	public AsteroidesController(Context context) {
		super(context);
		asteroides = new ArrayList<Asteroide>();
		background = new Background(context, 0, 0);
	}

	@Override
	public void stepObjects(Canvas canvas) {
		
		for (Asteroide a : asteroides) {
			if (a.isBottom(canvas))
				asteroides.remove(a);
		}
		
		stepCount++;
		if (stepCount >= WAIT) {
			
			Random random = new Random();
			
			
			Asteroide asteroide = new Asteroide(getContext(), 
					random.nextInt(canvas.getWidth()-60), 0);
			asteroides.add(asteroide);
			
			stepCount = 0;
		}
		
		for (Asteroide a : asteroides) {
			a.step(canvas);
		}
		
		//verificar colisão
	}

	@Override
	public void drawObjects(Canvas canvas) {
		
		background.draw(canvas);
		
		for (Asteroide a : asteroides) {
			a.draw(canvas);
		}
		
		
	}

}
