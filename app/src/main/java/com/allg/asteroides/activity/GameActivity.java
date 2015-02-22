package com.allg.asteroides.activity;

import android.os.Bundle;

import com.allg.asteroides.game.levels.LevelManager;

public class GameActivity extends FullscreenActivity {

    private LevelManager levelManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        levelManager = new LevelManager(this);
        setContentView(levelManager);
    }
	
	@Override
	protected void onResume() {
        levelManager.onResume();
        super.onResume();
	}

	@Override
	protected void onPause() {
        levelManager.onStop();
        super.onPause();
	}
	
	@Override
	protected void onStop() {
        levelManager.onStop();
        super.onStop();
	}
}
