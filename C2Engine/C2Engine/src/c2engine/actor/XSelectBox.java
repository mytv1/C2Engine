package c2engine.actor;

import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class XSelectBox extends SelectBox{
	private Runnable[] runables;
	int lastSelectIndex = -1;

	public XSelectBox(Object[] items, Skin skin, Runnable[] runables) {
		super(items, skin);
		this.runables = runables;
	}

	public XSelectBox(String[] items, Skin skin) {
		super(items, skin);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		if (getSelectionIndex() != lastSelectIndex){
			lastSelectIndex = getSelectionIndex();
			if (runables != null && runables[lastSelectIndex] != null)
			runables[lastSelectIndex].run();
		}
	}
	
	

}
