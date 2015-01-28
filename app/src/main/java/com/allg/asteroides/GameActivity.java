package com.allg.asteroides;

import android.app.Activity;
import android.os.Bundle;

import com.allg.asteroides.game.levels.LevelController;
import com.allg.asteroides.game.levels.LevelOnePrototype;
import com.allg.asteroides.game.levels.LevelPrototype;
import com.allg.asteroides.game.levels.LevelTwoPrototype;
import com.allg.asteroides.game.objects.Background;
import com.allg.asteroides.game.objects.BackgroundMusic;

public class GameActivity extends Activity {

    private LevelOnePrototype level1Prototype;
    private LevelTwoPrototype level2Prototype;

    private LevelPrototype level;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        level1Prototype = new LevelOnePrototype(this);
        level2Prototype = new LevelTwoPrototype(this);

        level = level1Prototype.clone();

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
