package api.asset;

import com.badlogic.gdx.utils.Array;

/**
 * The object which other can get asset from that
 * @author mytv
 *
 */
public interface AssetManageable { // "able" should be add in last of interface name, it's reminiscent that this is a interface
	
	public Iterable<Asset> getAssetsNeedToLoad();
	
	public Iterable<Asset> getAssetsNeedToUnload();
}
