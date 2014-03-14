package c2game.monsterdefence.game.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

import c2engine.asset.Asset;
import c2engine.asset.AssetManageable;
import c2engine.asset.FramesGenerator;
import c2engine.asset.ResourceManager;
import c2engine.screens.XScreen;
import c2engine.sprite.SpriteAnimation;
import c2engine.sprite.SpriteAnimationAccessor;
import c2game.monsterdefence.game.assets.Assets;
import c2game.monsterdefence.tool.Path;
import c2game.monsterdefence.tool.Paths;

public class ScreenPlay extends XScreen implements AssetManageable{
	SpriteAnimation sprite1, sprite2;
	private TweenManager manager = new TweenManager();
	
	
	@Override
	public void show() {
		configure();
		moveEnemyTest();
	}
	
	private void moveEnemyTest() {
		TextureAtlas atlas = ResourceManager.get(Assets.TA_GROUND_MONSTER, TextureAtlas.class);
		sprite1 = new SpriteAnimation(FramesGenerator.getKeyFrames(atlas, "snack-run-", 1, 6));
		sprite1.start(0.1f, Animation.LOOP);
		
		Paths paths = loadData();
		final Path path = paths.pathList.get(0);
		sprite1.setCenterXY(path.getNodes().get(0).x, path.getNodes().get(0).y);
		Tween.registerAccessor(SpriteAnimation.class, new SpriteAnimationAccessor());
		Tween.to(sprite1, SpriteAnimationAccessor.CPOS_XY, 2.0f)
			.target(path.getNodes().get(1).x, path.getNodes().get(1).y)
			.setCallback(new TweenCallback() {
				
				@Override
				public void onEvent(int type, BaseTween<?> source) {
					Tween.to(sprite1, SpriteAnimationAccessor.CPOS_XY, 2.0f)
					.target(path.getNodes().get(2).x, path.getNodes().get(2).y)
					.start(manager);
				}
			})
			.start(manager);
	}
	
	private Paths loadData() {
		try {
			FileHandle fileHandle = Gdx.files.internal("data/Level/Level1/path.txt");
			Json json = new Json();
			Paths paths = json.fromJson(Paths.class, fileHandle);
			return paths;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void configure() {
		camera = new OrthographicCamera(800, 480);
		camera.position.set(400, 240, 0);
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
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
		batch.begin();
		sprite1.draw(batch);
		batch.end();
	}

	@Override
	public void update(float delta) {
		camera.update();
		batch.setProjectionMatrix(camera.combined);
		sprite1.update(delta);
		manager.update(delta);
	}

	@Override
	public Iterable<Asset> loadNeedAssets() {
		Array<Asset> assets = new Array<Asset>();
		assets.add(Assets.TA_GROUND_MONSTER);
		return assets;
	}

	@Override
	public Iterable<Asset> unloadAssets() {
		// TODO Auto-generated method stub
		return null;
	}

}
