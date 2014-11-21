package br.com.llg.cargame.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import br.com.llg.cargame.R;
import br.com.llg.cargame.engine.GameObject;

public class Asteroide extends GameObject {

	private Bitmap bitmap;
	private int passoY = 3;
	
	public Asteroide(Context context, int x, int y) {
		super(context, x, y);
		this.x = x;
		this.y = y;
		
		//instanciar bitmap
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.asteroide);
		this.height = bitmap.getHeight();
		this.width = bitmap.getWidth();
	}

	@Override
	public void initObject() {

	}

	@Override
	public void step(Canvas canvas) {
		
		y += passoY;

	}

	@Override
	public void draw(Canvas canvas) {

		canvas.drawBitmap(bitmap, x, y, null);

	}

	public boolean isBottom(Canvas canvas) {
		
		if (y >= canvas.getHeight())
			return true;
		
		return false;
	}

}
