package br.com.llg.asteroides.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;
import br.com.llg.asteroides.game.SpaceShip;

public class Left extends GameObject{

	private Bitmap left;
	private Paint paint;

	private float x = 0;
	private float y = 0;

	public Left(Context context, int x, int y) {
		super(context, x, y);
 		left = BitmapFactory.decodeResource(getResources(), R.drawable.left);
		


		this.width = left.getWidth();
		this.height = left.getHeight();

	}

	@Override
	public void initObject(Canvas canvas) {


	}

	@Override
	public void step(Canvas canvas) {


	}

	@Override
	public void draw(Canvas canvas) {

		x = 0;
		y = canvas.getHeight() - (canvas.getHeight()/4);

		canvas.drawBitmap(left, x, y, paint);

	}

	public boolean onTouchEvent(MotionEvent event, SpaceShip ship) {

		if(event.getX() >= x && event.getX() <= x+width){
			if(event.getY() >= y && event.getY() <= y+height){
				ship.irEsquerda();
			}
		}
		return false;		
	}

}
