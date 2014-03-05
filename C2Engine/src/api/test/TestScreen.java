package api.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import api.asset.Asset;
import api.asset.AssetManageable;
import api.asset.ResourceManager;
import api.screens.MyScreen;

public class TestScreen extends MyScreen implements AssetManageable {
	Texture texture;

	@Override
	public void show() {
		configure();
		texture = ResourceManager.getTexture(TestAssets.TX_TEST_BACKGROUND);
	}

	/**
	 * Configure your screen (camera, spritebatch .... )
	 */
	private void configure() {
		camera = new OrthographicCamera(800, 480);
		camera.position.set(400, 240, 0);
		spriteBatch = new SpriteBatch();
		spriteBatch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

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
	public void draw(float delta) {
		spriteBatch.begin();
		spriteBatch.draw(texture, 0, 0);
		spriteBatch.end();
	}

	@Override
	public void update(float delta) {
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		if (Gdx.input.justTouched())
			setScreen(new TestScreen2());
	}

	@Override
	public Iterable<Asset> getAssetsNeedToLoad() {
		Array<Asset> assets = new Array<Asset>();
		assets.add(TestAssets.TX_TEST_BACKGROUND);
		return assets;
	}

	@Override
	public Iterable<Asset> getAssetsNeedToUnload() {
		return null;
	}

}
