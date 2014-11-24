package br.com.llg.asteroides.buttons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;
import br.com.llg.asteroides.game.SpaceShip;

public class Left extends GameObject{

	private Bitmap bitmap;
	private SpaceShip ship; 

	public Left(Context context, int x, int y, SpaceShip ship) {
		super(context, x, y);
 		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.left);

		this.width = bitmap.getWidth();
		this.height = bitmap.getHeight();
		this.ship = ship;
	}

	@Override
	public void initObject(Canvas canvas) {}

	@Override
	public void step(Canvas canvas) {
		x = 0;
		y = canvas.getHeight() - (canvas.getHeight()/4);
	}

	@Override
	public void draw(Canvas canvas) {
		canvas.drawBitmap(bitmap, x, y, null);
	}

	public boolean onTouch(MotionEvent event) {
		
		if(event.getX() >= x && event.getX() <= x+width){
			if(event.getY() >= y && event.getY() <= y+height){
				ship.irEsquerda();
			}
		} else ship.normal();

		return false;		
	}

}
