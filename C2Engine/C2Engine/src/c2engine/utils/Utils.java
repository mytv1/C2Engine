package c2engine.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Utils {
	private static final String VNI_CHAR = "()Ã¡Â»ï¿½!?Ã¡Â»ï¿½Ã¡ÂºÂ§ÃƒÂ³ÃƒÂ£:1234567890$AÃ„â€šÃƒâ€šBCDÃ„ï¿½EÃƒÅ GHIKLMNOÃƒâ€�Ã†Â PQRSTUÃ†Â¯VXYaÃ„Æ’ÃƒÂ¢bcdÃ„â€˜eÃƒÂªghiklmnoÃƒÂ´Ã†Â¡pqrstuÃ†Â°vxyÃ¡Â»â„¢Ã¡Â»Â¥Ã¡Â»â€˜Ã¡Â»Æ’ÃƒÂ []Ã¡ÂºÂ­ÃƒÂ¡ÃƒÂºÃ¡ÂºÂ»Ã¡Â»â€ºÃ¡Â»ï¿½Ã¡Â»Â©Ã¡ÂºÂ¯Ã¡ÂºÂ¥Ã¡Â»Å¸Ã¡Â»Â£Ã¡ÂºÂ©Ã¡Â»â€¹ÃƒÂ¬ÃƒÂ­Ã¡Â»Â±ÃƒÂ©Ã¡Â»â€œÃ¡ÂºÂ¡Ã¡Â»Â­Ã¡ÂºÂ¿Ã¡ÂºÂ£Ã¡ÂºÂ¢Ã¡Â»â€¢Ã¡Â»â€�";

	/**
	 * make bitmap font from true type font
	 * 
	 * @param file
	 * @param size
	 * @param isVNIFont
	 * @return
	 */
	protected static BitmapFont getFontGenerate(String file, int size,
			boolean isVNIFont) {
		BitmapFont font;
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
				Gdx.files.internal(file));
		if (isVNIFont)
			font = generator.generateFont(size, VNI_CHAR, false);
		else
			font = generator.generateFont(size);
		generator.dispose();
		return font;
	}

	/**
	 * Load Particle Effect
	 * 
	 * @param folder
	 * @param fileName
	 * @return
	 */
	public static ParticleEffect loadParticleEffect(String folder,
			String fileName) {
		ParticleEffect effect;

		effect = new ParticleEffect();
		effect.load(Gdx.files.internal(folder + "/" + fileName),
				Gdx.files.internal(folder));

		return effect;
	}

	/**
	 * Load Particle Effect
	 * 
	 * @param folder
	 *            : path + file name
	 * @param TextureAtlas
	 * @return
	 */
	public static ParticleEffect loadParticleEffect(String folder,
			TextureAtlas atlas) {
		ParticleEffect effect;

		effect = new ParticleEffect();
		effect.load(Gdx.files.internal(folder), atlas);

		return effect;
	}

	public static void printTouchPosition(float width, float height) {
		System.out.println("X : " + Gdx.input.getX() * width
				/ Gdx.graphics.getWidth() + " Y : "
				+ (Gdx.graphics.getHeight() - Gdx.input.getY()) * height
				/ Gdx.graphics.getHeight());
	}

}
