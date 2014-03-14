package c2engine.actor;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class XLabel extends Label {

	public XLabel(CharSequence text, Skin skin) {
		super(text, skin);
	}
	
	public void setCenter(float x,float y){
		setPosition(x-getMinWidth()/2, y-getMinHeight()/2);
	}

	public float getCenterX(){
		return getX() + getMinWidth()/2;
	}
	
	public float getCenterY(){
		return getY() + getMinHeight()/2;
	}
	
}
