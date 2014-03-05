package c2engine.test;

import c2engine.asset.FramesGenerator;
import c2engine.sprite.SpriteAnimation;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class TestSpriteAnimation extends SpriteAnimation{
	float timeCount;
	TextureRegion[] flyFrames, dieFrames;
	byte state = 1;
	
	public TestSpriteAnimation() {
		flyFrames = FramesGenerator.getFramesFromTexture(TestAssets.TX_TEST_DRAGON, 1, 6);
		dieFrames = FramesGenerator.getFramesFromTexture(TestAssets.TX_TEST_DRAGON_DIE, 1, 6);
		setKeyFrames(flyFrames);
		start(0.1f, Animation.LOOP);
		resize(0.5f);
		setCenterXY(400, 240);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		switch (state) {
		case 1:
			timeCount += delta;
			if (timeCount > 1f){
				state = 2;
				timeCount = 0;
				resetFrame();
				setFrameDuration(0.15f);
				setKeyFrames(dieFrames);
				resize(0.5f);
			}
			break;
		case 2:
			if (isAnimationFinished())
			{
				state = 1;
				resetFrame();
				setFrameDuration(0.1f);
				setKeyFrames(flyFrames);
				resize(0.5f);
			}
		default:
			break;
		}
	
	}
	
	

}
