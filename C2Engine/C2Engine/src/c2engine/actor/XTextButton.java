package c2engine.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class XTextButton extends TextButton{
	
	public XTextButton(Skin skin,String name) {
		super(name, skin);
	}
	
	public XTextButton(String text, Skin skin, String styleName){
		super(text, skin, styleName);
	}
	
	public void resize(float amount){
		setSize(getWidth()*amount, getHeight()*amount);
	}

}
