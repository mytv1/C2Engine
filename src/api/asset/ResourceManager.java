package api.asset;

import com.badlogic.gdx.assets.AssetManager;

/**
 * 
 * @author mytv
 * 
 */
public class ResourceManager {
	private static AssetManager assetManager = new AssetManager();

	public static AssetManager getAssetManager() {
		return assetManager;
	}

	public static void loadAssets(Iterable<Asset> assets) {
		for (Asset asset : assets) {
			loadAsset(asset);
		}
	}

	public static void loadAssets(Asset... assets) {
		for (Asset asset : assets) {
			loadAsset(asset);
		}
	}

	public static void unloadAssets(Iterable<Asset> assets) {
		for (Asset asset : assets) {
			unLoadAsset(asset);
		}
	}

	public static void unloadAssets(Asset... assets) {
		for (Asset asset : assets) {
			unLoadAsset(asset);
		}
	}

	public static boolean isLoadDone() {
		return assetManager.update();
	}

	public static void unLoadAsset(Asset asset) {
		assetManager.unload(asset.pathName);
	}

	public static void loadAsset(Asset asset) {
		assetManager.load(asset.pathName, asset.clazz);
	}

}
