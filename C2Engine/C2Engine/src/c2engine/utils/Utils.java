package c2engine.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Utils {
	private static final String VNI_CHAR = "()á»�!?á»�áº§Ã³Ã£:1234567890$AÄ‚Ã‚BCDÄ�EÃŠGHIKLMNOÃ”Æ PQRSTUÆ¯VXYaÄƒÃ¢bcdÄ‘eÃªghiklmnoÃ´Æ¡pqrstuÆ°vxyá»™á»¥á»‘á»ƒÃ []áº­Ã¡Ãºáº»á»›á»�á»©áº¯áº¥á»Ÿá»£áº©á»‹Ã¬Ã­á»±Ã©á»“áº¡á»­áº¿áº£áº¢á»•á»”";
	
	/**
	 * make bitmap font from true type font
	 * @param file
	 * @param size
	 * @param isVNIFont
	 * @return
	 */
	protected static BitmapFont getFontGenerate(String file, int size, boolean isVNIFont) {
		BitmapFont font;
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(file));
		if (isVNIFont) font = generator.generateFont(size, VNI_CHAR, false);
		else font = generator.generateFont(size);
		generator.dispose();
		return font;
	}
	
	/**
	 * Load Particle Effect
	 * @param folder
	 * @param fileName
	 * @return
	 */
	public static ParticleEffect loadParticleEffect (String folder, String fileName) {
		ParticleEffect effect;
		
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal(folder + "/" + fileName), Gdx.files.internal(folder));
		
		return effect;
	}
	
	/**
	 * Load Particle Effect
	 * @param folder: path + file name
	 * @param TextureAtlas
	 * @return
	 */
	public static ParticleEffect loadParticleEffect (String folder, TextureAtlas atlas) {
		ParticleEffect effect;
		
		effect = new ParticleEffect();
		effect.load(Gdx.files.internal(folder), atlas);
		
		return effect;
	}
}
