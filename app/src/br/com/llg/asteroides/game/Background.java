package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;

public class Background extends GameObject {

	private Bitmap bitmap;
	
	public Background(Context context, int x, int y) {
		super(context, x, y);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.background);
	}

	@Override
	public void initObject(Canvas canvas) {

	}

	@Override
	public void step(Canvas canvas) {

	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x, y, null);

	}

}
