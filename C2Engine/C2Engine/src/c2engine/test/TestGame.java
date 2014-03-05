package c2engine.test;


import c2engine.game.XGame;
import c2engine.screens.LoadingScreenAbstract;

import com.badlogic.gdx.Screen;

public class TestGame extends XGame {

	@Override
	public void onCreate() {
		
	}
	
	/**
	 * set your customize loading screen (with background, something else...), nothing inside is acceptable
	 */
	@Override
	public LoadingScreenAbstract createLoadingScreen() {
		return new TestLoadingScreen();
	}

	/**
	 * set your customize first screen to start game
	 */
	@Override
	public Screen createStartedScreen() {
		return new TestScreen();
	}

	
	
}
