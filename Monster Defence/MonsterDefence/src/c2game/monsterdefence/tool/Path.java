package c2game.monsterdefence.tool;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Path {
	
	Array<Vector2> nodes;
	
	
	public void setNodes(Array<Vector2> nodes) {
		this.nodes = nodes;
	}
	
	public Array<Vector2> getNodes() {
		return nodes;
	}

}
