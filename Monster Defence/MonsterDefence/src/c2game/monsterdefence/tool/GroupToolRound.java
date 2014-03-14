package c2game.monsterdefence.tool;

import c2engine.actor.XTextButton;
import c2engine.asset.ResourceManager;
import c2game.monsterdefence.game.assets.Assets;
import c2game.monsterdefence.tool.GroupToolPathEdit.PathButton;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GroupToolRound extends Group{
	private ScreenToolMainMenu screenToolMainMenu;
	private XTextButton btBack, btAdd, btDelete, btReset,btDelay, btSpawn;
	private SelectBox sbPath;

	public GroupToolRound(ScreenToolMainMenu screenToolMainMenu) {
		this.screenToolMainMenu = screenToolMainMenu;
		initButtons();
	}

	private void initButtons() {
		Skin skin = ResourceManager.getSkin(Assets.SK_UI);
		btAdd = new XTextButton(skin, "Add");
		btAdd.setSize(100, 40);
		btAdd.setPosition(220, 400);
		addActor(btAdd);

		btDelete = new XTextButton(skin, "Delete");
		btDelete.setPosition(220, 320);
		btDelete.setSize(100, 40);
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
	}
	
	class ButtonRound extends Group{
		XTextButton btRound;
		
		public ButtonRound(int index) {
			initButton(index);
		}

		private void initButton(int index) {
			Skin skin = ResourceManager.getSkin(Assets.SK_UI);
			btRound = new XTextButton("Round "+index,skin,"toggle");
			addActor(btRound);
		}
		
	}
}
