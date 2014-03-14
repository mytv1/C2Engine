package c2game.monsterdefence.game.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import c2engine.asset.Asset;

public class Assets {
	// tool gui
	public static Asset SK_UI = new Asset("tool-gui/uiskin.json", Skin.class);
	
	// backgrounds
	public static Asset TX_BG_MAP_1 = new Asset("drawable/backgrounds/bgmap1.jpg", Texture.class);
	public static Asset TX_BG_MAP_2 = new Asset("drawable/backgrounds/bgmap2.jpg", Texture.class);
	public static Asset TX_BG_MAP_3 = new Asset("drawable/backgrounds/bgmap3.jpg", Texture.class);
	
	// ground monsters
	public static Asset TA_GROUND_MONSTER = new Asset("drawable/objects/groundmonsters.atlas", TextureAtlas.class);
	
	// fly monsters
	public static Asset TA_FLY_MONSTER = new Asset("drawable/objects/flymonsters.atlas", TextureAtlas.class);
	
	// warriors
	public static Asset TX_CUNGTHU_ATK_BEHIND = new Asset("drawable/objects/cungthu-atk-behind.png", Texture.class);
	public static Asset TX_CUNGTHU_ATK_FRONT = new Asset("drawable/objects/cungthu-atk-front.png", Texture.class);
	public static Asset TX_CUNGTHU_NORMAL = new Asset("drawable/objects/cungthu-normal.png", Texture.class);
	
	public static Asset TX_DAOSI_ATK_BEHIND = new Asset("drawable/objects/daosi-atk-behind.png", Texture.class);
	public static Asset TX_DAOSI_ATK_FRONT = new Asset("drawable/objects/daosi-atk-front.png", Texture.class);
	public static Asset TX_DAOSI_NORMAL = new Asset("drawable/objects/daosi-normal.png", Texture.class);
	
	public static Asset TX_KIEMSI_ATK_BEHIND = new Asset("drawable/objects/kiemsi-atk-behind.png", Texture.class);
	public static Asset TX_KIEMSI_ATK_FRONT = new Asset("drawable/objects/kiemsi-atk-front.png", Texture.class);
	public static Asset TX_KIEMSI_NORMAL = new Asset("drawable/objects/kiemsi-normal.png", Texture.class);
	
	public static Asset TX_MAIHOA_ATK_BEHIND = new Asset("drawable/objects/maihoa-atk-behind.png", Texture.class);
	public static Asset TX_MAIHOA_ATK_FRONT = new Asset("drawable/objects/maihoa-atk-front.png", Texture.class);
	public static Asset TX_MAIHOA_NORMAL = new Asset("drawable/objects/maihoa-normal.png", Texture.class);
	
	public static Asset TX_THANHLONG_ATK_BEHIND = new Asset("drawable/objects/thanhlong-atk-behind.png", Texture.class);
	public static Asset TX_THANHLONG_ATK_FRONT = new Asset("drawable/objects/thanhlong-atk-front.png", Texture.class);
	public static Asset TX_THANHLONG_NORMAL = new Asset("drawable/objects/thanhlong-normal.png", Texture.class);
	
	public static Asset TX_TIENNHAN_ATK_BEHIND = new Asset("drawable/objects/tiennhan-atk-behind.png", Texture.class);
	public static Asset TX_TIENNHAN_ATK_FRONT = new Asset("drawable/objects/tiennhan-atk-front.png", Texture.class);
	public static Asset TX_TIENNHAN_NORMAL = new Asset("drawable/objects/tiennhan-normal.png", Texture.class);
	
	public static Asset TX_TUONGQUAN_ATK_BEHIND = new Asset("drawable/objects/tuongquan-atk-behind.png", Texture.class);
	public static Asset TX_TUONGQUAN_ATK_FRONT = new Asset("drawable/objects/tuongquan-atk-front.png", Texture.class);
	public static Asset TX_TUONGQUAN_NORMAL = new Asset("drawable/objects/tuongquan-normal.png", Texture.class);
	
	public static Asset TX_XATHAN_ATK_BEHIND = new Asset("drawable/objects/xathan-atk-behind.png", Texture.class);
	public static Asset TX_XATHAN_ATK_FRONT = new Asset("drawable/objects/xathan-atk-front.png", Texture.class);
	public static Asset TX_XATHAN_NORMAL = new Asset("drawable/objects/xathan-normal.png", Texture.class);
	
	public static Asset TX_XICHLONG_ATK_BEHIND = new Asset("drawable/objects/xichlong-atk-behind.png", Texture.class);
	public static Asset TX_XICHLONG_ATK_FRONT = new Asset("drawable/objects/xichlong-atk-front.png", Texture.class);
	public static Asset TX_XICHLONG_NORMAL = new Asset("drawable/objects/xichlong-normal.png", Texture.class);
	
	// towers
	public static Asset TX_TOWER_HOVE = new Asset("drawable/objects/hove.png", Texture.class);
	public static Asset TX_TOWER_MOCTHAN = new Asset("drawable/objects/mocthan.png", Texture.class);
	public static Asset TX_TOWER_THACHDON = new Asset("drawable/objects/thachdon.png", Texture.class);
	public static Asset TX_TOWER_TINHHON = new Asset("drawable/objects/tinhhon.png", Texture.class);
	
	// String
	public static String STR_TOOL_WRITE_PATH = "tool";
}
