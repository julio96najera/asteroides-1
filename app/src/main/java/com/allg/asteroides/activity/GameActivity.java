package com.allg.asteroides.activity;

import android.app.Activity;
import android.os.Bundle;

import com.allg.asteroides.game.levels.LevelController;
import com.allg.asteroides.game.levels.LevelManager;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class GameActivity extends Activity {

    private LevelManager levelManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        levelManager = new LevelManager(this);
        setContentView(levelManager);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
        levelManager.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
        levelManager.stop();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
        levelManager.stop();
	}
}
