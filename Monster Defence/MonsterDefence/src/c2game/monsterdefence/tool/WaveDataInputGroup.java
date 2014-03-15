package c2game.monsterdefence.tool;

import c2engine.actor.XImage;
import c2engine.actor.XLabel;
import c2engine.actor.XSelectBox;
import c2engine.asset.FramesGenerator;
import c2engine.asset.ResourceManager;
import c2game.monsterdefence.game.assets.Assets;
import c2game.monsterdefence.tool.GroupToolPathEdit.PathButton;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class WaveDataInputGroup extends Group {

	private static final String DEFAULT_SPAWN_RATE = "2.0";
	private static final String DEFAULT_WAVE_DELAY = "2.0";
	private static final String DEFAULT_AMOUNT = "0";
	TextField tfWaveSpawnRateInput, tfWaveDelayInput, tfEnemyNumberInput;
	SelectBox sbEnemyTypeSelect;
	SelectBox sbPathSelect;
	XImage imgBoard;
	Array<XLabel> nodes = new Array<XLabel>();
	private Paths paths;

	public WaveDataInputGroup() {
		init();
		initWhiteBoardImage();
	}

	private void initWhiteBoardImage() {
		imgBoard = new XImage(ResourceManager.getTexture(Assets.TX_WHITE_BOARD));
		imgBoard.setBounds(330, 15, 450, 275);
		imgBoard.setColor(Color.DARK_GRAY);
		addActor(imgBoard);
	}

	private void init() {
		Skin skin = ResourceManager.get(Assets.SK_UI, Skin.class);

		/* Enemy Type Select */
		initEnemyTypeSelectBox(skin);

		initPathSelectBox(skin);

		/* Wave Spawn rate */
		tfWaveSpawnRateInput = new TextField("", skin);
		tfWaveSpawnRateInput.setMessageText("SpawnRate");
		tfWaveSpawnRateInput.setPosition(440, 420);
		tfWaveSpawnRateInput.setWidth(100);
		tfWaveSpawnRateInput.setText(DEFAULT_SPAWN_RATE);
		addActor(tfWaveSpawnRateInput);

		Label lbSpawnRate = new Label("Spawn rate", skin);
		lbSpawnRate.setPosition(tfWaveSpawnRateInput.getX(),
				tfWaveSpawnRateInput.getY() - 30);
		lbSpawnRate.setColor(Color.GREEN);
		addActor(lbSpawnRate);

		/* Wave Delay */
		tfWaveDelayInput = new TextField("", skin);
		tfWaveDelayInput.setMessageText("Delay");
		tfWaveDelayInput.setPosition(560, 420);
		tfWaveDelayInput.setWidth(100);
		tfWaveDelayInput.setText(DEFAULT_WAVE_DELAY);
		addActor(tfWaveDelayInput);

		Label lbDelay = new Label("Delay", skin);
		lbDelay.setPosition(tfWaveDelayInput.getX(),
				tfWaveDelayInput.getY() - 30);
		lbDelay.setColor(Color.BLUE);
		addActor(lbDelay);

		/* Health modify */
		tfEnemyNumberInput = new TextField("", skin);
		tfEnemyNumberInput.setPosition(680, 420);
		tfEnemyNumberInput.setWidth(110);
		tfEnemyNumberInput.setMessageText("Amount");
		tfEnemyNumberInput.setText(DEFAULT_AMOUNT);
		addActor(tfEnemyNumberInput);

		Label lbHealthModify = new Label("Amount", skin);
		lbHealthModify.setPosition(tfEnemyNumberInput.getX(),
				tfEnemyNumberInput.getY() - 30);
		lbHealthModify.setColor(Color.RED);
		addActor(lbHealthModify);

	}

	private void initPathSelectBox(Skin skin) {

		try {
			FileHandle fileHandle = Gdx.files.internal("path.txt");
			Json json = new Json();
			paths = json.fromJson(Paths.class, fileHandle);
			String[] items = new String[paths.pathList.size];
			for (int i = 0; i < items.length; i++) {
				items[i] = "Path " + (i + 1);
			}
			sbPathSelect = new SelectBox(items, skin) {
				int lastSelect = -1;

				@Override
				public void act(float delta) {
					super.act(delta);
					if (lastSelect != getSelectionIndex()) {
						lastSelect = getSelectionIndex();
						showPath(lastSelect);
					}
				}
			};
			sbPathSelect.setPosition(515, 335);
			addActor(sbPathSelect);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void showPath(int lastSelect) {
		for(XLabel xLabel : nodes){
			xLabel.remove();
		}
		nodes.clear();
		Path path = paths.pathList.get(lastSelect);
		int index = 1;
		Skin skin = ResourceManager.get(Assets.SK_UI, Skin.class);
		for(Vector2 vector2 : path.nodes){
			XLabel node = new XLabel(""+index, skin);
			node.setCenter(vector2.x/1200*imgBoard.getWidth()+imgBoard.getX(), vector2.y/720*imgBoard.getHeight()+imgBoard.getY());
			index++;
			addActor(node);
			nodes.add(node);
		}
	}

	private void initEnemyTypeSelectBox(Skin skin) {
		sbEnemyTypeSelect = new SelectBox(new String[] { "Snail", "Snack",
				"Undead Worm", "Pumpkin Ghost", "Dark Ghost", "Dark Warrior",
				"Zombie", "Teddy Nightmare", "Master Dark Warrior",
				"Dark Dragon", "Fire Dragon", "Butcher", "Tikbalang",
				"Lord of The Dragon", "Immortal Fappy" }, skin) {
			int lastSelect = -1;

			@Override
			public void act(float delta) {
				super.act(delta);
				if (lastSelect != getSelectionIndex()) {
					lastSelect = getSelectionIndex();
				}
			}

		};
		sbEnemyTypeSelect.setPosition(320, 420);
		sbEnemyTypeSelect.setWidth(100);
		addActor(sbEnemyTypeSelect);
	}

	public Wave getWaveData() throws Exception {
		Wave wave = new Wave();
		try {
			wave.enemyType = Integer.parseInt(""
					+ (sbEnemyTypeSelect.getSelectionIndex() + 1));
			wave.enemyTotal = Integer.parseInt(tfEnemyNumberInput.getText());
			wave.spawnRate = Float.parseFloat(tfWaveSpawnRateInput.getText());
			wave.delayStart = Float.parseFloat(tfWaveDelayInput.getText());
			wave.enemyTotal = Integer.parseInt(tfEnemyNumberInput.getText());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return wave;
	}

	public void loadWaveData(Wave wave) {
		sbEnemyTypeSelect.setSelection(wave.enemyType - 1);
		tfEnemyNumberInput.setText((int) wave.enemyTotal + "");
		tfWaveDelayInput.setText(wave.delayStart + "");
		tfWaveSpawnRateInput.setText(wave.spawnRate + "");
		tfEnemyNumberInput.setText(wave.enemyTotal + "");
	}
}
