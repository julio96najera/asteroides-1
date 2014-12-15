package com.allg.asteroides;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.allg.asteroides.game.Level1Controller;

public class Level1Activity extends Activity {

	private Level1Controller controller;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		controller = new Level1Controller(this);
		setContentView(controller);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		controller.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
		controller.stop();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
        controller.stop();
	}
}
