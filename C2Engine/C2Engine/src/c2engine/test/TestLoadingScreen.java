package c2engine.test;

import c2engine.asset.ResourceManager;
import c2engine.screens.LoadingScreenAbstract;

public class TestLoadingScreen extends LoadingScreenAbstract{

	@Override
	public void show() {
		
	}
	
	@Override
	public void resize(int width, int height) {
		
	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRender(float render) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preload() {
		ResourceManager.preloadAssets(TestAssets.TX_TEST_BACKGROUND);
	}

}
