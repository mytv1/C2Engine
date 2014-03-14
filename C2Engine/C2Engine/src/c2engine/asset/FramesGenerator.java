package c2engine.asset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
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
	
	/**
	 * get key frames
	 * @param textureAtlas
	 * @param keyFrame
	 * @param startFrame
	 * @param endFrame
	 * @return keyFrames
	 */
	public static TextureRegion[] getKeyFrames(TextureAtlas textureAtlas, String keyFrame, int startFrame, int endFrame) {
		int size = endFrame - startFrame + 1;
		
		TextureRegion[] trRegions = new TextureRegion[size];
		
		for (int i = 0; i < size; i++) {
			trRegions[i] = textureAtlas.findRegion(keyFrame+(i+startFrame));
		}
		
		return trRegions;
	}
	
	/**
	 * get keyframe
	 * @param keyFrames
	 * @return keyframes
	 */
	public static TextureRegion[] getKeyFrames(TextureRegion[] ... keyFrames) {
		int size = 0;
		for (int i = 0; i < keyFrames.length; i++) {
			size += keyFrames[i].length;
		}
		
		int k = 0;
		TextureRegion[] trRegions = new TextureRegion[size];
		
		for (int i = 0; i < keyFrames.length; i++) {
			for (int j = 0; j < keyFrames[i].length; j++) {
				trRegions[k] = keyFrames[i][j];
				k++;
			}
		}
		
		return trRegions;
	}

}
