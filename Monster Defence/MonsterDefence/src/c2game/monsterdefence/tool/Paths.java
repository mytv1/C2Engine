package c2game.monsterdefence.tool;

import com.badlogic.gdx.utils.Array;

public class Paths {
	
	public Array<Path> pathList = new Array<Path>();
	
	public void setPathList(Array<Path> pathList) {
		this.pathList = pathList;
	}
	
	public Array<Path> getPathList() {
		return pathList;
	}

}
