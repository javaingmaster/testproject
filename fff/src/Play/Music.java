package Play;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * * * @author Zheng Mofang * @date Jun 23, 2017 * @description Please use as
 * this: Music music = new * Music("src/music/add.wav");This class can only
 * support the audio * file that ends with .wav. *
 */
public class Music {
	Clip clip;

	public Music(String fileName) {
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(fileName));
			clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, stream.getFormat()));
			clip.open(stream);
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}

	public void playSound() {
		clip.start();
	}

	public void stopSound() {
		clip.stop();
	}
}
