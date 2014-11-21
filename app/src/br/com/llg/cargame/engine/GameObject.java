package br.com.llg.cargame.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public abstract class GameObject extends View {

	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	public GameObject(Context context) {
		super(context);
	}
	
	public abstract void initObject();
	public abstract void step(Canvas canvas);
	public abstract void draw(Canvas canvas);

}
