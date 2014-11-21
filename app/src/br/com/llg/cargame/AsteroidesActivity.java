package br.com.llg.cargame;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import br.com.llg.cargame.game.AsteroidesController;

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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car_game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
