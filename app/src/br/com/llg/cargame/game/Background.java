package br.com.llg.cargame.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import br.com.llg.cargame.engine.GameObject;

public class Background extends GameObject {

	public Background(Context context, int x, int y) {
		super(context, x, y);
	}

	@Override
	public void initObject() {

	}

	@Override
	public void step(Canvas canvas) {

	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.YELLOW);

	}

}
