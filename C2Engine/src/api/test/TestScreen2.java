package api.test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;

import api.asset.Asset;
import api.asset.AssetManageable;
import api.asset.FramesGenerator;
import api.asset.ResourceManager;
import api.screens.MyScreen;
import api.sprite.SpriteAnimation;

public class TestScreen2 extends MyScreen implements AssetManageable {
	SpriteAnimation spriteAnimationSimple;
	TestSpriteAnimation testSpriteAnimation;
	
	@Override
	public void show() {
		initSpriteAnimation();
		initTestSpriteAnimation();
	}
	
	private void initTestSpriteAnimation() {
		testSpriteAnimation = new TestSpriteAnimation();
	}

	private void initSpriteAnimation() {
		spriteAnimationSimple = new SpriteAnimation(FramesGenerator.getFramesFromTextureType1(TestAssets.TX_TEST_DRAGON, 6));
		spriteAnimationSimple.resize(0.5f);
		spriteAnimationSimple.start(0.1f,Animation.LOOP);
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
	public Iterable<Asset> getAssetsNeedToLoad() {
		Array<Asset> assets = new Array<Asset>();
		assets.add(TestAssets.TX_TEST_BACKGROUND);
		assets.addAll(TestAssets.PACK_TEST_DRAGON);
		return assets;
	}

	@Override
	public Iterable<Asset> getAssetsNeedToUnload() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(float delta) {
		spriteBatch.begin();
		spriteBatch.draw(ResourceManager.getTexture(TestAssets.TX_TEST_BACKGROUND),200,0);
		spriteAnimationSimple.draw(spriteBatch);
		testSpriteAnimation.draw(spriteBatch);
		spriteBatch.end();
	}

	@Override
	public void update(float delta) {
		spriteAnimationSimple.update(delta);
		testSpriteAnimation.update(delta);
		if (Gdx.input.justTouched())
			setScreen(new TestScreen());
	}

}
