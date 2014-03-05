package api.asset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;



public class FramesGenerator {

	/*
	 * get frames from image (from asset) that contain a list of frame, arranged in line 
	 */
	public static TextureRegion[] getFramesFromTextureType1(Asset asset,
			int length) {
		Texture texture = ResourceManager.get(asset, Texture.class);
		return getFramesFromTextureType1(texture, length);
	}

	/*
	 * get frames from image that contain a list of frame, arranged in line 
	 */
	private static TextureRegion[] getFramesFromTextureType1(Texture texture, int length) {
		TextureRegion[] textureRegions;
		int width = texture.getWidth() / length;
		int height = texture.getHeight();
		textureRegions = new TextureRegion[length];
		for (int i = 0; i < length; i++) {
			textureRegions[i] = new TextureRegion(texture, i * width, 0, width,
					height);
		}
		return textureRegions;
	}

}
