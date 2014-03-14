package c2engine.utils;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager {
	public static boolean SOUND_ENABLE = true;
	public static boolean MUSIC_ENABLE = true;

	public static void playSound(Sound sound, float volume) {
		if (SOUND_ENABLE) {
			sound.play(volume);
		}
	}
	
	public static void playeSound(Sound sound) {
		if (SOUND_ENABLE) {
			sound.play();
		}
	}

	public static void playMusic(Music music, float volume, boolean loop) {
		if (MUSIC_ENABLE) {
			music.setLooping(loop);
			music.setVolume(volume);
			music.play();
		}
	}

	public static void pauseMusic(Music music) {
		music.pause();
	}
	
	public static void stopSound(Sound sound) {
		sound.stop();
	}
}
