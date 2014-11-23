package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import br.com.llg.asteroides.R;
import br.com.llg.asteroides.engine.GameObject;
import br.com.llg.asteroides.engine.Sprite;

public class SpaceShip extends GameObject{
	
	private Bitmap bitmap;
	private Sprite sprite;
	
	private int passoX = 10;
	
	private class Direction {
		public static final int LEFT = 0;
		public static final int NORMAL = 1;
		public static final int RIGHT = 2;
	}
	
	private int direcao = Direction.NORMAL;

	
	public SpaceShip(Context context, int x, int y) {
		super(context, x, y);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
		
		this.width = bitmap.getWidth() / 3;
		this.height = bitmap.getHeight();
		
		this.sprite = new Sprite(bitmap, 1, 3);
	}
	
	public void initObject(Canvas canvas) {
		
		x = canvas.getWidth()/2;
	}

	public void irEsquerda(){
		
//		x = x + (passoX/2);
//		fColuna = 0;
//		x = x + (passoX/2);
//		fColuna = 1;
		
		x += passoX;
		direcao = Direction.LEFT;
		
	}
	
	public void irDireita(){
		
//		x = x + (passoX/2);
//		fColuna = 2;
//		x = x + (passoX/2);
//		fColuna = 1;
		
		x -= passoX;
		direcao = Direction.RIGHT;
		
	}
	
	@Override
	public void step(Canvas canvas) {
		y = canvas.getHeight() - height;	
	}

	@Override
	public void draw(Canvas canvas) {

		
//		int left = fLinha * wFrame ;
//		int top = fColuna * hFrame ;
//		int bottom = top + hFrame ;
//		int right = left + wFrame ;
//
//		Rect src = new Rect(top, left,  bottom, right);
//		Rect dst = new Rect(x, y, x + wFrame, y + hFrame);

		sprite.draw(canvas, 0, direcao);
	}
}
