package c2game.monsterdefence.tool;

import c2engine.actor.XSelectBox;
import c2engine.actor.XTextButton;
import c2engine.asset.ResourceManager;
import c2game.monsterdefence.game.assets.Assets;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class GroupToolRound extends Group {
	private ScreenToolMainMenu screenToolMainMenu;
	private XTextButton btBack, btAdd, btDelete, btReset, btDelay, btSpawn;
	private XSelectBox sbRound;
	private Table table;

	public GroupToolRound(ScreenToolMainMenu screenToolMainMenu) {
		this.screenToolMainMenu = screenToolMainMenu;
		initButtons();
		initRoundSelectScrollPane();
	}

	private void initRoundSelectScrollPane() {
		Skin skin = ResourceManager.getSkin(Assets.SK_UI);
		table = new Table(skin);
		ScrollPane scrollPane = new ScrollPane(table, skin);
		scrollPane.setBounds(50, 110, 130, 330);
		addActor(scrollPane);
	}

	private void initButtons() {
		final Skin skin = ResourceManager.getSkin(Assets.SK_UI);
		btAdd = new XTextButton(skin, "Add");
		btAdd.setBounds(220, 180, 100, 40);
		btAdd.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				RoundDataStoredButton btRound = new RoundDataStoredButton(
						"Round 1",skin,1);
				btRound.addListener(new RoundButtonListener(btRound));
				table.add(btRound).pad(0, 0, 10, 0);
				table.row();
			}

		});
		addActor(btAdd);

		btDelete = new XTextButton(skin, "Delete");
		btDelete.setPosition(220, 120);
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

	public void setUncheckToAllRoundButton() {
		for (Actor actor : table.getChildren()) {
			((RoundDataStoredButton) actor).setChecked(false);
		}
	}

	public Array<RoundDataStoredButton> getListRoundDataButton(){
		Array<Actor> actors = table.getChildren();
		Array<RoundDataStoredButton> roundDataButtons = new Array<RoundDataStoredButton>();
		for(Actor actor : actors){
			roundDataButtons.add((RoundDataStoredButton) actor);
		}
		return roundDataButtons;
	}
	
	public RoundDataStoredButton getSelectedRoundButton(
			RoundDataStoredButton seletingRoundDataStoredButton) {
		Array<RoundDataStoredButton> roundDataButtons = getListRoundDataButton();
		for (int i = 0; i < roundDataButtons.size; i++)
			if (roundDataButtons.get(i).isChecked()
					&& roundDataButtons.get(i) != seletingRoundDataStoredButton) {
				return roundDataButtons.get(i);
			} 
		return null;
	}
	
	class RoundButtonListener extends ClickListener {
		RoundDataStoredButton roundDataStoredButton;

		public RoundButtonListener(RoundDataStoredButton roundDataStoredButton) {
			this.roundDataStoredButton = roundDataStoredButton;
		}

		@Override
		public void clicked(InputEvent event, float x, float y) {
			RoundDataStoredButton selectedRoundDataStoredButton = getSelectedRoundButton(roundDataStoredButton);
			if (selectedRoundDataStoredButton != null)
				selectedRoundDataStoredButton.removeChildren();
			setCheckedFalseAllRoundButton();
			roundDataStoredButton.setChecked(true);
			roundDataStoredButton.addChildren(GroupToolRound.this);
		}

		private void setCheckedFalseAllRoundButton() {
			Array<RoundDataStoredButton> roundDataButtons = getListRoundDataButton();
			for(RoundDataStoredButton roundDataStoredButton : roundDataButtons)
				roundDataStoredButton.setChecked(false);
		}

	}
}
