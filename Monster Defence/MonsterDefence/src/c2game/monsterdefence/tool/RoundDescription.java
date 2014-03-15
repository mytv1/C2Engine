package c2game.monsterdefence.tool;

import java.util.ArrayList;


public class RoundDescription {
	public ArrayList<Wave> waveList = new ArrayList<Wave>();
	
	public RoundDescription() {}
	
	public RoundDescription(ArrayList<Wave> waveList) {
		this.waveList = waveList;
	}
}
