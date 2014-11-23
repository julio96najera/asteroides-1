package br.com.llg.asteroides.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;
import br.com.llg.asteroides.game.AsteroidesController;
import br.com.llg.asteroides.game.SpaceShip;

public class Right extends GameObject{

	private Bitmap bitmap;
	private SpaceShip ship;


	public Right(Context context, int x, int y, SpaceShip ship) {
		super(context, x, y);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.right);

		this.width = bitmap.getWidth();
		this.height = bitmap.getHeight();
		this.ship = ship;

	}

	@Override
	public void initObject(Canvas canvas) {



	}

	@Override
	public void step(Canvas canvas) {

		x = canvas.getWidth() - width;
		y = canvas.getHeight() - (canvas.getHeight()/4);

	}

	@Override
	public void draw(Canvas canvas) {

		canvas.drawBitmap(bitmap, x, y, null);	

	}

	public boolean onTouchEvent(MotionEvent event) {
		
		if(event.getX() >= x && event.getX() <= x+width){
			if(event.getY() >= y && event.getY() <= y+height){
				ship.irDireita();
			}
		}
		return false;
	}



}
