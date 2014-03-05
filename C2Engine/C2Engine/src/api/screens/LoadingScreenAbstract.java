package api.screens;

import api.asset.Asset;
import api.asset.AssetManageable;
import api.asset.ResourceManager;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class LoadingScreenAbstract implements Screen {
	private Screen nextScreen_; // private attribute should be added "_" at
								// last, it's simple mark and a standard of code
	private Game game_;

	public void setGame(Game game) {
		game_ = game;
	}

	public void setNextScreen(Screen screen) {
		// unload last screen resource if need
		if (nextScreen_ != null && nextScreen_ instanceof AssetManageable) {
			Iterable<Asset> unloadAssets = ((AssetManageable) nextScreen_)
					.getAssetsNeedToUnload();
			if (unloadAssets != null)
				ResourceManager.unloadAssets(unloadAssets);
		}

		// load next screen resource if need
		if (screen instanceof AssetManageable) {
			Iterable<Asset> loadAssets = ((AssetManageable) screen)
					.getAssetsNeedToLoad();
			if (loadAssets != null)
				ResourceManager.loadAssets(loadAssets);
		}
		// System.out.println("set next");
		nextScreen_ = screen;
	}

	public void render(float delta) {
		onRender(delta);
		// System.out.println("percent : "+ResourceManager.getAssetManager().getProgress()
		// + " is loadone : "+ResourceManager.isLoadDone());
		// if unload and load is done, automatically set to next screen
		if (ResourceManager.isLoadDone()) {
			game_.setScreen(nextScreen_);
		}
	}

	// draw background, animation, anything else let code in below. It is
	// abstract because it's up to ideal of design
	public abstract void onRender(float render);

}
