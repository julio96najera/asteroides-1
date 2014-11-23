package br.com.llg.asteroides.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import br.com.llg.asteroides.engine.GameObject;

public class SpaceShip extends GameObject{
	
	private Bitmap nave;
	
	private int passoX = 10;
	
	int linhas = 1;
	int colunas = 3;

	int width;
	int heigth;

	int hFrame = 60;
	int wFrame = 60;

	int fLinha = 0; 
	int fColuna = 1;

	
	public SpaceShip(Context context, int x, int y) {
		super(context, x, y);
		nave = BitmapFactory.decodeResource(getResources(), br.com.llg.asteroides.R.drawable.spaceship);
		
		this.width = nave.getWidth() / colunas;
		this.height = nave.getHeight() / linhas;
			
	}
	
	public void initObject(Canvas canvas) {
		
		x = canvas.getWidth()/2;
	}

	public void irEsquerda(){
		
		x = x + (passoX/2);
		fColuna = 0;
		x = x + (passoX/2);
		fColuna = 1;
		
	}
	
	public void irDireita(){
		
		x = x + (passoX/2);
		fColuna = 2;
		x = x + (passoX/2);
		fColuna = 1;
		
	}
	
	@Override
	public void step(Canvas canvas) {
		
	}

	@Override
	public void draw(Canvas canvas) {

		y = canvas.getHeight() - height;	
		
		int left = fLinha * wFrame ;
		int top = fColuna * hFrame ;
		int bottom = top + hFrame ;
		int right = left + wFrame ;

		Rect src = new Rect(top, left,  bottom, right);
		Rect dst = new Rect(x, y, x + wFrame, y + hFrame);

		canvas.drawBitmap(nave, src, dst, null);
	}
}
