package c2game.monsterdefence.game.main;

import c2engine.game.XGame;
import c2engine.screens.LoadingScreenAbstract;
import c2game.monsterdefence.game.screens.LoadingScreen;
import c2game.monsterdefence.game.screens.ScreenPlay;
import c2game.monsterdefence.tool.ScreenToolMainMenu;

import com.badlogic.gdx.Screen;

public class MonsterDefence extends XGame {

	@Override
	public LoadingScreenAbstract createLoadingScreen() {
		return new LoadingScreen();
	}

	@Override
	public Screen createStartedScreen() {
		return new ScreenToolMainMenu();
//		return new ScreenPlay();
	}

	@Override
	public void onCreate() {
		setResolution(800, 480);
	}
}
