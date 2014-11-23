package br.com.llg.asteroides.engine;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
	
	private Bitmap bitmap;
	private int lines;
	private int columns;

    private int width;
    private int height;
    
    private GameObject object;
	
	public Sprite(Bitmap bitmap, int lines, int columns, GameObject object){
		this.bitmap = bitmap;
		this.lines = lines;
		this.columns = columns;
		
		this.width = bitmap.getWidth() / columns;
		this.height = bitmap.getHeight() / lines;
		
		this.object = object;
		
	}

	public void draw(Canvas canvas, int line, int column){
		int srcX = (column * width)+1;
        int srcY = (line * height)+1;
		
		Rect src = new Rect(srcX, srcY, srcX+width, srcY+height);
		
		Rect dst = new Rect(object.x, object.y, 
					object.x + width, object.y + height);
		
		canvas.drawBitmap(bitmap, src, dst, null);
	}
}
