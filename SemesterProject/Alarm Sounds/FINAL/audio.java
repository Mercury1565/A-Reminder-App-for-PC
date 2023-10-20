package FINAL;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;
public class audio {
	public static void audio() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Scanner scanner = new Scanner(System.in);
		File file = new File("rolling-tone.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip(); 
		clip.open(audioStream);
		
		clip.start();
		String x = scanner.next();
	}
	
	public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audio();
	}
	
}
