package c2game.monsterdefence.tool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Array;

import c2engine.actor.XTextButton;
import c2engine.asset.Asset;
import c2engine.asset.AssetManageable;
import c2engine.asset.ResourceManager;
import c2engine.screens.XScreen;
import c2engine.utils.Utils;
import c2game.monsterdefence.game.assets.Assets;

public class ScreenToolMainMenu extends XScreen implements AssetManageable{
	public GroupToolMainMenu groupToolMainMenu;
	public GroupToolPathEdit groupToolPathEdit;
	public GroupToolRound groupToolRound;
	
	@Override
	public void show() {
		initStage();
		initMainMenu();
		initPathEditGroup();
		initRoundEditGroup();
	}
	
	
	private void initRoundEditGroup() {
		groupToolRound = new GroupToolRound(this);
		groupToolRound.setVisible(false);
		stage.addActor(groupToolRound);
	}


	private void initPathEditGroup() {
		groupToolPathEdit = new GroupToolPathEdit(this);
		groupToolPathEdit.setVisible(false);
		stage.addActor(groupToolPathEdit);
	}


	private void initMainMenu() {
		groupToolMainMenu = new GroupToolMainMenu(this);
		stage.addActor(groupToolMainMenu);
	}


	private void initStage() {
		stage = new Stage(800, 480);
		inputMultiplexer.addProcessor(stage);
		Gdx.input.setInputProcessor(inputMultiplexer);
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
		stage.draw();
	}

	@Override
	public void update(float delta) {
		if (Gdx.input.justTouched())
			Utils.printTouchPosition(800,480);
		stage.act(delta);
		
	}


	@Override
	public Iterable<Asset> loadNeedAssets() {
		Array<Asset> assets = new Array<Asset>();
		assets.add(Assets.SK_UI);
		assets.add(Assets.TX_BG_MAP_1);
		assets.add(Assets.TX_BG_MAP_2);
		assets.add(Assets.TX_BG_MAP_3);
		assets.add(Assets.TX_WHITE_BOARD);
		return assets;
	}


	@Override
	public Iterable<Asset> unloadAssets() {
		// TODO Auto-generated method stub
		return null;
	}

}

