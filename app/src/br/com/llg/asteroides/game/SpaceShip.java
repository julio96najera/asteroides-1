package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import br.com.llg.asteroides.engine.GameObject;

public class SpaceShip extends GameObject{
	
	private Bitmap nave;
	private int passoX = 2;
	private int passoY = 2;

	
	public SpaceShip(Context context, int x, int y) {
		super(context, x, y);
		nave = BitmapFactory.decodeResource(getResources(), br.com.llg.asteroides.R.drawable.spaceship);
	}
	
	public void initObject(Canvas canvas) {
	
		x = canvas.getWidth()/2;
		y = 20;		
	}

	@Override
	public void step(Canvas canvas) {

		
	}

	@Override
	public void draw(Canvas canvas) {

		
	}

}
