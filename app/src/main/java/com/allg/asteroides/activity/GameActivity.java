package com.allg.asteroides.activity;

import android.os.Bundle;

import com.allg.asteroides.game.levels.LevelManager;

public class GameActivity extends FullscreenActivity {

    private LevelManager levelManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

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
