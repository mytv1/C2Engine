package api.game;

import api.screens.LoadingScreenAbstract;
import api.screens.MyScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public abstract class MyGame extends Game{

	LoadingScreenAbstract loadingScreenAbstract;

	@Override
	public void create() {
		configure();
		onCreate();
		setStartScreen();
	}

	private void setStartScreen() {
		setLoadingScreen(createStartedScreen());		
	}

	private void configure() {
		Gdx.input.setCatchBackKey(true);
		loadingScreenAbstract = createLoadingScreen();
		loadingScreenAbstract.setGame(this);
		MyScreen.setMyGame(this);
	}
	
	public abstract LoadingScreenAbstract createLoadingScreen();
	
	public abstract Screen createStartedScreen();

	public abstract void onCreate();

	public void setLoadingScreen(Screen screen) {
		loadingScreenAbstract.setNextScreen(screen);
		setScreen(loadingScreenAbstract);
	}
	

}
