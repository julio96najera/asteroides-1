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

	private Bitmap right;
	private Paint paint;
	
	float width;
	float height;

	private float x = 0;
	private float y = 0;


	public Right(Context context, int x, int y) {
		super(context, x, y);
		paint = new Paint();
		right = BitmapFactory.decodeResource(getResources(), R.drawable.right);
		

		this.width = right.getWidth();
		this.height = right.getHeight();

	}

	@Override
	public void initObject(Canvas canvas) {



	}

	@Override
	public void step(Canvas canvas) {


	}

	@Override
	public void draw(Canvas canvas) {

		x = canvas.getWidth() - width;
		y = canvas.getHeight() - (canvas.getHeight()/4);

		canvas.drawBitmap(right, x, y, paint);	

	}

	public boolean onTouchEvent(MotionEvent event,  SpaceShip ship) {
		
		if(event.getX() >= x && event.getX() <= x+width){
			if(event.getY() >= y && event.getY() <= y+height){
				ship.irDireita();
			}
		}
		return false;
	}



}
