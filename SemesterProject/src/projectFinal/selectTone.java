package projectFinal;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class selectTone extends JFrame{
	static File silentTone = new File("SILENCE.wav");
	static File selectedTone = new File("classic-short-alarm.wav");//The default tone is set here
	static File finalTone = new File("rolling-tone.wav"); 
	
	File audio1 = new File("alarm-tone.wav");
	File audio2 = new File("classic-short-alarm.wav");
	File audio3 = new File("game-notification-wave-alarm.wav");
	
	File toneOptions[] = {audio1,audio2,audio3};
	
	JComboBox chooseTone = new JComboBox(toneOptions);
	JButton Apply = new JButton("Apply");

	static AudioInputStream audioStream;
	static Clip clip;
	
	public static void audio2(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip(); 
		clip.open(audioStream);
		clip.loop(1);
		}
	public void terminateAudio2() {
		clip.close();
	}

	public class selectToneListener{

		public void actionPerformed(ActionEvent e){
			terminateAudio2();
			if(e.getSource() == chooseTone) {
				
				selectedTone = (File) chooseTone.getSelectedItem();
				try {
					audio2(selectedTone);
				} 
				catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
					}
				}
			if(e.getSource() == Apply) {
				finalTone = selectedTone;
				try {
					terminateAudio2();
					audio2(selectedTone);
				}
				catch (NullPointerException | UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
				}
			}
		}
	}
}


