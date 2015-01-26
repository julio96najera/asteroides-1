package com.allg.asteroides;

import android.app.Activity;
import android.os.Bundle;

import com.allg.asteroides.engine.level.LevelController;
import com.allg.asteroides.game.objects.Background;
import com.allg.asteroides.game.objects.BackgroundMusic;

public class GameActivity extends Activity {

    private LevelController level;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        level = new LevelController(
                this,
                new Background(this, 0, 0),
                new BackgroundMusic(this, true),
                40,
                30
        );

		setContentView(level);

	}
	
	@Override
	protected void onResume() {
		super.onResume();
        level.resume();
	}

	@Override
	protected void onPause() {
		super.onPause();
        level.stop();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
        level.stop();
	}
}
