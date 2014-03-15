package c2game.monsterdefence.tool;

import java.util.ArrayList;

import c2engine.asset.ResourceManager;
import c2game.monsterdefence.game.assets.Assets;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class RoundDataStoredButton extends TextButton {
	SelectBox selectBox;
	int round;
	int numberOfWave;
	Group group = new Group();
	Group miniGroup;
	TextField tfInputNumberOfWave;
	TextButton tbtInputNumberOfWave;
	WaveDataInputGroup[] waveDetailInputGroups;

	public RoundDataStoredButton(String text, Skin skin, int round) {
		super(text, skin, "toggle");
		this.round = round;
		initNumberWaveInputRequestGroup();
	}

	public void initSelectBox(int numberOfWave) {
		this.numberOfWave = numberOfWave;
		Skin skin = ResourceManager.get(Assets.SK_UI,
				Skin.class);
		String[] strElements = new String[numberOfWave];

		for (int i = 0; i < numberOfWave; i++) {
			strElements[i] = new String("Wave " + (i + 1));
		}
		selectBox = new SelectBox(strElements, skin) {
			int lastSelect = -1;

			@Override
			public void act(float delta) {
				super.act(delta);
				if (lastSelect != getSelectionIndex()) {
					if (lastSelect > -1) {
						waveDetailInputGroups[lastSelect].remove();
					}
					group.addActor(waveDetailInputGroups[getSelectionIndex()]);
					lastSelect = getSelectionIndex();
				}
			}

		};
		selectBox.setPosition(200, 420);
		group.addActor(selectBox);
	}

	public void initWaveDetailInputGroups(int numberOfWave) {
		waveDetailInputGroups = new WaveDataInputGroup[numberOfWave];
		for (int i = 0; i < numberOfWave; i++) {
			waveDetailInputGroups[i] = new WaveDataInputGroup();
		}
		group.addActor(waveDetailInputGroups[0]);
	}

	public void removeChildren() {
		group.remove();
	}

	public void addChildren(Group parentGroup) {
		parentGroup.addActor(group);
	}

	public void initNumberWaveInputRequestGroup() {
		Skin skin = ResourceManager.get(Assets.SK_UI,
				Skin.class);

		miniGroup = new Group();
		/* input number of round */
		tfInputNumberOfWave = new TextField("", skin);
		tfInputNumberOfWave.setMessageText("Please input number of waves!");
		tfInputNumberOfWave.setPosition(200, 420);
		tfInputNumberOfWave.setWidth(250);
		miniGroup.addActor(tfInputNumberOfWave);

		/* input number of round */
		tbtInputNumberOfWave = new TextButton("Enter", skin);
		tbtInputNumberOfWave.setPosition(300, 380);
		tbtInputNumberOfWave.addListener(new ClickListener() {

			@Override
			public void clicked(InputEvent event, float x, float y) {
				try {
					int numberOfWave = Integer.parseInt(tfInputNumberOfWave
							.getText());
					initSelectBox(numberOfWave);
					initWaveDetailInputGroups(numberOfWave);
					miniGroup.remove();
				} catch (Exception e) {
					
				}

			}

		});
		miniGroup.addActor(tbtInputNumberOfWave);
		group.addActor(miniGroup);
	}

	public void removeNumberWaveInputRequestGroup() {
		miniGroup.remove();
	}

	public void loadWavesData(RoundDescription roundDescription) {
		initSelectBox(roundDescription.waveList.size());
		initWaveDetailInputGroups(roundDescription.waveList.size());
		for (int i = 0; i < roundDescription.waveList.size(); i++) {
			waveDetailInputGroups[i].loadWaveData(roundDescription.waveList
					.get(i));
		}
	}

	public void removeWaveDetailInputGroup() {
		for (int i = 0; i < waveDetailInputGroups.length; i++) {
			waveDetailInputGroups[i].remove();
		}
	}

	public void resetAllActors() {
		if (waveDetailInputGroups != null){
			for (int i = 0; i < waveDetailInputGroups.length; i++) {
				waveDetailInputGroups[i].remove();
			}
			waveDetailInputGroups = null;
		}
		if (selectBox != null)
			selectBox.remove();
		if (!group.isAscendantOf(miniGroup))
			initNumberWaveInputRequestGroup();
	}
}
