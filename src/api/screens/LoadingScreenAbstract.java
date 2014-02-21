package api.screens;

import api.asset.AssetManageable;
import api.asset.ResourceManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class LoadingScreenAbstract implements Screen {
	private Screen nextScreen_; // private attribute should be added "_" at last, it's simple mark and a standard of code
	private Game game_;

	public void setGame(Game game){
		game_ = game;
	}
	
	public void setNextScreen(Screen screen) {
		// unload last screen resource if need
		if (nextScreen_ != null && nextScreen_ instanceof AssetManageable) {
			ResourceManager.unloadAssets(((AssetManageable) nextScreen_)
					.getAssetsNeedToUnload());
		}

		// load next screen resource if need
		if (screen instanceof AssetManageable) {
			ResourceManager.loadAssets(((AssetManageable) screen)
					.getAssetsNeedToLoad());
		}
		nextScreen_ = screen;
	}

	public void render(float delta) {
		onRender(delta);
		
		// if unload and load is done, automatically set to next screen
		if (ResourceManager.isLoadDone()) {
			game_.setScreen(nextScreen_);
		}
	}

	// draw background, animation, anything else let code in below. It is abstract because it's up to ideal of design
	public abstract void onRender(float render);

}
