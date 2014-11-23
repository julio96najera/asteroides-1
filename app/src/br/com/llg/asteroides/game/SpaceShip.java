package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;
import br.com.llg.asteroides.engine.Sprite;

public class SpaceShip extends GameObject{
	
	private Bitmap bitmap;
	private Sprite sprite;
	
	private int tWidth;
	
	private int passoX = 10;
	
	private class Direction {
		private static final int LEFT = 0;
		private static final int NORMAL = 1;
		private static final int RIGHT = 2;
	}
	
	private int direcao = Direction.NORMAL;

	
	public SpaceShip(Context context, int x, int y) {
		super(context, x, y);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
		
		this.width = bitmap.getWidth() / 3;
		this.height = bitmap.getHeight();
		
		this.sprite = new Sprite(bitmap, 1, 3, this);
	}
	
	public void initObject(Canvas canvas) {
		x = canvas.getWidth()/2 - width;
	}

	public void irEsquerda(){
			
		if(x >= passoX && x <= tWidth){
			x -= passoX;
			direcao = Direction.LEFT;
		}
	}
	
	public void irDireita(){
			
		if(x >= 0 && x <= tWidth - (passoX+width)){
			x += passoX;
			direcao = Direction.RIGHT;
		}
	}
	
	public void normal(){
		direcao = Direction.NORMAL;
	}
	
	@Override
	public void step(Canvas canvas) {
		tWidth = canvas.getWidth();
		y = canvas.getHeight() - (height + 10);	
	}

	@Override
	public void draw(Canvas canvas) {

		sprite.draw(canvas, 0, direcao);
	}
}
