package com.allg.asteroides;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.allg.asteroides.game.AsteroidesController;

public class AsteroidesActivity extends Activity {

	private AsteroidesController asteroidesController;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		asteroidesController = new AsteroidesController(this);
		setContentView(asteroidesController);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		asteroidesController.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		asteroidesController.stop();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		asteroidesController.stop();
	}
}
