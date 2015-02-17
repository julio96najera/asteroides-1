package com.allg.asteroides.activity;

import android.app.Activity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.WindowManager;

import com.allg.asteroides.game.levels.LevelManager;

public class GameActivity extends Activity {

    private LevelManager levelManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        levelManager = new LevelManager(this);
        levelManager.onCreate();
    }
	
	@Override
	protected void onResume() {
		super.onResume();
        levelManager.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
        levelManager.onStop();
	}
	
	@Override
	protected void onStop() {
        levelManager.onStop();
        super.onStop();
	}
}
