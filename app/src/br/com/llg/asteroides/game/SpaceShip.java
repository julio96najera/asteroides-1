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
	private Bitmap explosionBitmap;
	private Sprite sprite;
	private Sprite explosionSprite;

	private int passoX = 10;

	private class Direction {
		private static final int LEFT = 0;
		private static final int NORMAL = 1;
		private static final int RIGHT = 2;
	}

	private int direcao = Direction.NORMAL;

	private Boolean explosion = false;
	private int explosionCount = 0;

	public SpaceShip(Context context, int x, int y) {
		super(context, x, y);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spaceship);
		explosionBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.explosion);

		this.width = bitmap.getWidth() / 3;
		this.height = bitmap.getHeight();

		this.sprite = new Sprite(bitmap, 1, 3, this);
		this.explosionSprite = new Sprite(explosionBitmap, 1, 5, this);

	}

	public void initObject(Canvas canvas) {
		x = canvas.getWidth()/2 - width;
	}

	public void irEsquerda(){
		direcao = Direction.LEFT;
	}

	public void irDireita(){
		direcao = Direction.RIGHT;
	}

	public void normal(){
		direcao = Direction.NORMAL;
	}

	@Override
	public void step(Canvas canvas) {

		if (!explosion) {
			switch (direcao) {
			case Direction.LEFT:
				if (x >= passoX) {
					x -= passoX;
				}
				break;
			case Direction.RIGHT:
				if (x <= canvas.getWidth() - (passoX+width)) {
					x += passoX;
				}
				break;
			}

			y = canvas.getHeight() - (height + 10);
		}
	}

	@Override
	public void draw(Canvas canvas) {

		if (explosion) {
			explosionSprite.draw(canvas, 0, explosionCount);
			explosionCount++;
		} else {
			sprite.draw(canvas, 0, direcao);
		}
	}

	public void explodir() {
		explosion = true;
	}
}
