package c2engine.actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class XImage extends Image{
	
	public void setTexture(Texture texture){
		setDrawable(new TextureRegionDrawable(new TextureRegion(texture)));
	}
}
