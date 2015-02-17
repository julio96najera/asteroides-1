package com.allg.asteroides.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.allg.asteroides.R;


public class MainActivity extends FullscreenActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start(View v){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void credits(View v){
        Intent intent = new Intent(this, CreditsActivity.class);
        startActivity(intent);
    }
}
