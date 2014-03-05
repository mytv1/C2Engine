package c2engine.asset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FramesGenerator {

	/*
	 * get frames from image (from asset) that contain a list of frame, arranged in line 
	 */
	public static TextureRegion[] getFramesFromTexture(Asset asset, int rows, int cols) {
		Texture texture = ResourceManager.get(asset, Texture.class);
		return frameSplit(texture, rows, cols);
	}
	
	/**
	 * Split TextureRegion for Animation
	 * @param textureRegion
	 * @param rows
	 * @param cols
	 * @return TextureRegion[]
	 */
	private static TextureRegion[] frameSplit (Texture texture, int rows, int cols) {
		TextureRegion[] result;
		int tileWidth = texture.getWidth() / cols;
		int tileHeight = texture.getHeight() / rows;
		
		TextureRegion[][] temp = new TextureRegion(texture).split(tileWidth, tileHeight);
		result = new TextureRegion[cols * rows];
		
		int index = 0;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[index++] = temp[i][j];
			}
		}
		
		return result;
	}

}
