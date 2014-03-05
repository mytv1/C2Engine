package api.test;

import api.game.MyGame;
import api.screens.LoadingScreenAbstract;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TestGame extends MyGame {

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
