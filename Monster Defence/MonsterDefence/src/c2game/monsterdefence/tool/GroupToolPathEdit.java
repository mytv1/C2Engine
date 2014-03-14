package c2game.monsterdefence.tool;

import c2engine.actor.XImage;
import c2engine.actor.XLabel;
import c2engine.actor.XTextButton;
import c2engine.asset.ResourceManager;
import c2engine.game.XGame;
import c2game.monsterdefence.game.assets.Assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;

public class GroupToolPathEdit extends Group {

	XTextButton btBack, btAdd, btDelete, btReset, btSave;
	ScrollPane scrollPane;
	ScreenToolMainMenu screenToolMainMenu;

	XImage imgBackground;
	static String backgroundPathName = "";
	Array<XLabel> nodes = new Array<XLabel>();
	private Table table;
	SelectBox sbBackgrounds;

	public GroupToolPathEdit(ScreenToolMainMenu screenToolMainMenu) {
		initScrollPane();
		initButtons();
		initBackgroundImage();
		initBackgroundSelectBox();
		loadData();
		this.screenToolMainMenu = screenToolMainMenu;
	}

	private void loadData() {
		try {
			FileHandle fileHandle = Gdx.files.internal("path.txt");
			Json json = new Json();
			Paths paths = json.fromJson(Paths.class, fileHandle);
			for (Path path : paths.pathList) {
				Skin skin = ResourceManager.getSkin(Assets.SK_UI);
				PathButton pathButton = new PathButton(skin, "Path "
						+ (table.getChildren().size + 1));
				pathButton.setSize(80, 20);
				pathButton.setNodes(path.nodes);
				table.add(pathButton).padBottom(10);
				table.row();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initBackgroundSelectBox() {
		Skin skin = ResourceManager.getSkin(Assets.SK_UI);
		sbBackgrounds = new SelectBox(new String[] { "Background 1",
				"Background 2", "Background 3" }, skin) {
			int lastSelection = -1;

			@Override
			public void act(float delta) {
				super.act(delta);
				if (getSelectionIndex() != lastSelection) {
					setSuitableBackground(getSelectionIndex());
					lastSelection = getSelectionIndex();
					// imgBackground.setTexture()
				}
			}

			private void setSuitableBackground(int i) {
				Texture texture;
				switch (i) {
				case 0:
					texture = ResourceManager.getTexture(Assets.TX_BG_MAP_1);
					break;
				case 1:
					texture = ResourceManager.getTexture(Assets.TX_BG_MAP_2);
					break;
				case 2:
					texture = ResourceManager.getTexture(Assets.TX_BG_MAP_3);
					break;
				default:
					texture = ResourceManager.getTexture(Assets.TX_BG_MAP_3);
					break;
				}
				imgBackground.setTexture(texture);
			}

		};
		sbBackgrounds.setBounds(650, 420, 150, 40);
		addActor(sbBackgrounds);
	}

	private void initBackgroundImage() {
		imgBackground = new XImage();
		imgBackground.setBounds(330, 15, 450, 275);
		imgBackground.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Skin skin = ResourceManager.getSkin(Assets.SK_UI);
				int size = nodes.size;
				final XLabel label = new XLabel("" + (size + 1), skin);
				label.setCenter(Gdx.input.getX(),
						XGame.getHeight() - Gdx.input.getY());
				nodes.add(label);
				addActor(label);

			}

		});
		addActor(imgBackground);
	}

	private void initButtons() {
		// Add button
		Skin skin = ResourceManager.getSkin(Assets.SK_UI);
		btAdd = new XTextButton(skin, "Add");
		btAdd.setSize(100, 40);
		btAdd.setPosition(220, 400);
		btAdd.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				Skin skin = ResourceManager.getSkin(Assets.SK_UI);
				PathButton pathButton = new PathButton(skin, "Path "
						+ (table.getChildren().size + 1));
				pathButton.setSize(80, 20);
				table.add(pathButton).padBottom(10);
			}

		});
		addActor(btAdd);

		btDelete = new XTextButton(skin, "Delete");
		btDelete.setPosition(220, 320);
		btDelete.setSize(100, 40);
		btDelete.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				PathButton pathButton = getCheckingPathButton();
				table.removeActor(pathButton);
				resetListPathButtonIndex();
			}

		});
		addActor(btDelete);

		btBack = new XTextButton(skin, "Back");
		btBack.setPosition(40, 15);
		btBack.setSize(100, 40);
		btBack.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				setVisible(false);
				screenToolMainMenu.groupToolMainMenu.setVisible(true);
			}

		});
		addActor(btBack);

		btReset = new XTextButton(skin, "Reset");
		btReset.setBounds(440, 320, 100, 40);
		btReset.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				clearNodes();
			}

		});
		addActor(btReset);

		btSave = new XTextButton(skin, "Save");
		btSave.setBounds(550, 320, 100, 40);
		btSave.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				super.clicked(event, x, y);
				PathButton pathButton = getCheckingPathButton();
				if (pathButton != null)
					pathButton.clone(nodes);
			}

		});
		addActor(btSave);
	}

	private void resetListPathButtonIndex() {
		int index = 0;
		for (Actor pathButton : table.getChildren()) {
			{
				((PathButton) pathButton).setText("Path " + (index + 1));
				index++;
			}
		}
	}

	public PathButton getCheckingPathButton() {
		for (Actor pathButton : table.getChildren()) {
			{
				if (((PathButton) pathButton).isChecked()) {
					return (PathButton) pathButton;
				}
			}
		}
		return null;
	}

	public void setUncheckAllPathButton() {
		for (Actor pathButton : table.getChildren()) {
			{
				((PathButton) pathButton).setChecked(false);
			}
		}
	}

	private void initScrollPane() {
		Skin skin = ResourceManager.getSkin(Assets.SK_UI);
		table = new Table(skin);
		scrollPane = new ScrollPane(table, skin);
		scrollPane.setBounds(50, 110, 130, 330);
		addActor(scrollPane);
	}

	public void clearNodes() {
		for (Label label : nodes)
			label.remove();
		nodes.clear();
	}

	public Paths getPaths() {
		Paths paths = new Paths();

		for (Actor pathButton : table.getChildren()) {
			{
				Path path = new Path();
				path.setNodes(((PathButton) pathButton).nodes);
				paths.pathList.add(path);
			}
		}

		return paths;

	}

	class PathButton extends XTextButton {
		public Array<Vector2> nodes = new Array<Vector2>();

		public PathButton(Skin skin, String name) {
			super(name, skin, "toggle");
			addShowPathClickListener();
		}

		private void addShowPathClickListener() {
			addListener(new ClickListener() {

				@Override
				public void clicked(InputEvent event, float x, float y) {
					clearNodes();
					Skin skin = ResourceManager.getSkin(Assets.SK_UI);
					for (int i = 0; i < PathButton.this.nodes.size; i++) {
						Vector2 vector2 = PathButton.this.nodes.get(i);
						XLabel xLabel = new XLabel("" + (i + 1), skin);
						xLabel.setCenter((vector2.x)/1200*imgBackground.getWidth()+imgBackground.getX(), (vector2.y)/720*imgBackground.getHeight()+imgBackground.getY());
						GroupToolPathEdit.this.nodes.add(xLabel);
						GroupToolPathEdit.this.addActor(xLabel);
					}
					setUncheckAllPathButton();
					PathButton.this.setChecked(true);
				}

			});
		}

		public void setNodes(Array<Vector2> nodes) {
			this.nodes = nodes;
		}

		public Array<Vector2> getNodes() {
			return nodes;
		}

		public void clone(Array<XLabel> nodes) {
			PathButton.this.nodes.clear();
			for (XLabel xLabel : nodes) {
				PathButton.this.nodes.add(new Vector2((xLabel.getCenterX()-imgBackground.getX())*1200/imgBackground.getWidth(),
						(xLabel.getCenterY()-imgBackground.getY())*720/imgBackground.getHeight()));
			}
		}

	}

}
