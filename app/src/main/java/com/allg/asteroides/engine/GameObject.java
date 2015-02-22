package com.allg.asteroides.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

public abstract class GameObject extends View {

	protected int x;
	protected int y;
	
	protected int width;
	protected int height;
	
	public GameObject(Context context, int x, int y) {
		super(context);
		setX(x);
		setY(y);
	}
	
	public abstract void initObject(Canvas canvas);
	public abstract void step(Canvas canvas);
	public abstract void draw(Canvas canvas);

    public int getPosY() {
        return y;
    }

    public int getPosX() {
        return x;
    }
}
