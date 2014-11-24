package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import br.com.llg.asteroides.engine.GameObject;

public class Background extends GameObject {

	public Background(Context context, int x, int y) {
		super(context, x, y);
	}

	@Override
	public void initObject(Canvas canvas) {

	}

	@Override
	public void step(Canvas canvas) {

	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawColor(Color.rgb(0, 0, 55));

	}

}
