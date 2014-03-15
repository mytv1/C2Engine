package c2engine.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class XImage extends Image{
	
	public XImage() {
		super();
	}
	
	public XImage(Texture texture){
		super(texture);
	}
	
	public void setTexture(Texture texture){
		setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
	}
}
