package c2game.monsterdefence.tool;


public class Wave {
	public static byte SIMPLE_RUNNER = 1, DRAGON = -1; // Runner : > 0, Flyer :
														// < 0
	public static byte WEST_PATH_TO_EASE_GATE = 1;

	/* Wave base attribute */
	public int enemyType;
	public int enemyTotal;
	public float spawnRate;
	public float delayStart;
	
	/* Wave handler attribute */
	public float spawnTimeCount = 0;
	public float delayStartTimeCount = 0;
	public int enemyCount = 0;

	public Wave() {
	}

	public Wave(float enemyType, int count, float spawnRate, 
			float delayStart) {
		setData(enemyType, count, spawnRate,  delayStart);
	}

	public void setData(float enemyType, int enemyTotal, float spawnRate,
		 float delayStart) {
		this.enemyType = (int) enemyType;
		this.enemyTotal = enemyTotal;
		this.spawnRate = spawnRate;
		this.delayStart = delayStart;
	}
	

	public boolean isFlyerType() {
		return (enemyType >= 9 && enemyType <= 13) ? true : false;
	}

//	public void printWaveData() {
//		D.out(" enemy type : " + enemyType);
//		D.out(" enemy total : " + enemyTotal);
//		D.out(" spawn rate : " + spawnRate);
//		D.out(" delay start : " + delayStart);
//		D.out(" start point : "+iStart+"-"+jStart);
//		D.out(" end point : "+iEnd+"-"+jEnd);
//	}

	
}
