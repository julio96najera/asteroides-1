package com.allg.asteroides.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.allg.asteroides.R;
import com.allg.asteroides.game.objects.Main;


public class MainActivity extends FullscreenActivity {

    private Main main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        main = new Main(this);
        setContentView(main);

    }

    public void start(View view){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void credits(View view){
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        View view = new View(this);

        if(event.getY() >= main.start_y && event.getY() <= (main.start_y + main.start.getHeight())){
            if(event.getX() >= main.x && event.getX() <= (main.x + main.start.getWidth())){
                start(view);
            }
        }

        if(event.getY() >= main.opcoes_y && event.getY() <= (main.opcoes_y + main.opcoes.getHeight())){
            if(event.getX() >= main.x && event.getX() <= (main.x + main.opcoes.getWidth())){

            }
        }

        if(event.getY() >= main.creditos_y && event.getY() <= (main.creditos_y + main.creditos.getHeight())){
            if(event.getX() >= main.x && event.getX() <= (main.x + main.opcoes.getWidth())){
                credits(view);
            }
        }
        return super.onTouchEvent(event);
    }
}