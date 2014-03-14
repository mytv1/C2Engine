package c2game.monsterdefence.tool;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import c2engine.actor.XTextButton;
import c2engine.asset.ResourceManager;
import c2game.monsterdefence.game.assets.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Json;

public class GroupToolMainMenu extends Group {
	XTextButton btPath, btRound, btEnemy, btMap, btWave, btSave, btTest,
			btExit;
	ScreenToolMainMenu screenToolMainMenu;

	public GroupToolMainMenu(ScreenToolMainMenu screenToolMainMenu) {
		initButtons();
		this.screenToolMainMenu = screenToolMainMenu;
	}

	private void initButtons() {
		Skin skin = ResourceManager.get(Assets.SK_UI, Skin.class);
		float anchorX = 60, anchorY = 400;

		btPath = new XTextButton(skin, "Path");
		btPath.setPosition(anchorX, anchorY);
		btPath.setSize(100, 40);
		btPath.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				screenToolMainMenu.groupToolPathEdit.setVisible(true);
				setVisible(false);
			}

		});
		addActor(btPath);

		btRound = new XTextButton(skin, "Round");
		btRound.setBounds(anchorX, anchorY - 80, 100, 40);
		btRound.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				screenToolMainMenu.groupToolRound.setVisible(true);
				setVisible(false);
			}

		});
		addActor(btRound);

		btEnemy = new XTextButton(skin, "Enemy");
		btEnemy.setPosition(anchorX, anchorY - 160);
		btEnemy.setSize(100, 40);
		addActor(btEnemy);

		btMap = new XTextButton(skin, "Map");
		btMap.setPosition(anchorX, anchorY - 240);
		btMap.setSize(100, 40);
		addActor(btMap);

		btSave = new XTextButton(skin, "Save");
		btSave.setBounds(655, 415, 100, 40);
		btSave.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				writePathDataFile();
			}

			private void writePathDataFile() {
				try {
					Paths paths = screenToolMainMenu.groupToolPathEdit
							.getPaths();
					Json json = new Json();
					Writer writer = new BufferedWriter(new OutputStreamWriter(
							new FileOutputStream("path.txt"), "utf-8"));
					writer.write(json.toJson(paths, Paths.class));
					writer.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		addActor(btSave);

		btTest = new XTextButton(skin, "Test");
		btTest.setPosition(385, 30);
		btTest.setSize(100, 40);
		addActor(btTest);

		btExit = new XTextButton(skin, "Exit");
		btExit.setPosition(500, 30);
		btExit.setSize(100, 40);
		btExit.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Gdx.app.exit();
			}

		});
		addActor(btExit);

	}
}
