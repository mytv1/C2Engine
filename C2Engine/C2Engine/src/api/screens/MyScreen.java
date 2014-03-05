package api.screens;

import api.game.MyGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class MyScreen implements Screen{
	protected static Camera camera;
	protected static SpriteBatch spriteBatch;
	protected static MyGame myGame;
	protected static InputMultiplexer inputMultiplexer;
	
	public static void setMyGame(MyGame myGame) {
		MyScreen.myGame = myGame;
	}
	
	public void setScreen(Screen screen){
		myGame.setLoadingScreen(screen);
	}

	@Override
	public void render(float delta) {
		update(delta);
		clear();
		draw(delta);
	}

	private void clear() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);		
	}

	public abstract void draw(float delta) ;

	public abstract void update(float delta);
	
	
	
}
