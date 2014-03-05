package c2engine.test;

import c2engine.asset.Asset;

import com.badlogic.gdx.graphics.Texture;


public class TestAssets {
	public static Asset TX_TEST_BACKGROUND = new Asset("data/libgdx.png",Texture.class);
	
	public static Asset TX_TEST_DRAGON = new Asset("data/rong.png",Texture.class);
	public static Asset TX_TEST_DRAGON_DIE = new Asset("data/rong_die.png",Texture.class);
	
	public static Asset[] PACK_TEST_DRAGON = new Asset[]{TX_TEST_DRAGON,TX_TEST_DRAGON_DIE};
}
