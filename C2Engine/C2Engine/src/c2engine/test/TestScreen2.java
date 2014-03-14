package c2engine.test;

import c2engine.asset.Asset;
import c2engine.asset.AssetManageable;
import c2engine.asset.FramesGenerator;
import c2engine.asset.ResourceManager;
import c2engine.screens.XScreen;
import c2engine.sprite.SpriteAnimation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;


public class TestScreen2 extends XScreen implements AssetManageable {
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
		spriteAnimationSimple = new SpriteAnimation(FramesGenerator.getFramesFromTexture(TestAssets.TX_TEST_DRAGON, 1, 6));
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
	public Iterable<Asset> loadNeedAssets() {
		Array<Asset> assets = new Array<Asset>();
		assets.add(TestAssets.TX_TEST_BACKGROUND);
		assets.addAll(TestAssets.PACK_TEST_DRAGON);
		return assets;
	}

	@Override
	public Iterable<Asset> unloadAssets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(float delta) {
		batch.begin();
		batch.draw(ResourceManager.getTexture(TestAssets.TX_TEST_BACKGROUND),200,0);
		spriteAnimationSimple.draw(batch);
		testSpriteAnimation.draw(batch);
		batch.end();
	}

	@Override
	public void update(float delta) {
		spriteAnimationSimple.update(delta);
		testSpriteAnimation.update(delta);
		if (Gdx.input.justTouched())
			setScreen(new TestScreen());
	}

}
