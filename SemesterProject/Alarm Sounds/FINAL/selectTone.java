package FINAL;
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
	static File selectedTone = new File("rolling-tone.wav");//The default tone is set here
	
	File finalTone;
	
	File audio1 = new File("alarm-tone.wav");
	File audio2 = new File("classic-short-alarm.wav");
	File audio3 = new File("game-notification-wave-alarm.wav");
	
	File toneOptions[] = {audio1,audio2,audio3};
	
	JComboBox chooseTone = new JComboBox(toneOptions);
	JButton select = new JButton("Select");

	selectTone(){
		Container c = getContentPane();
		setLocation(200,200);
		setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c.setLayout(new GridLayout(7,1));
        
        c.add(chooseTone);
        c.add(select);
        
        chooseTone.addActionListener(new Il());
        select.addActionListener(new Il());
        setVisible(true);
        
	}
	static AudioInputStream audioStream;
	static Clip clip;
	
	public static void audio(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		//clip.close();
		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip(); 
		clip.open(audioStream);
		clip.loop(1);
		}
	public void terminateAudio() {
		clip.close();
	}

	private class Il implements ActionListener {

		public void actionPerformed(ActionEvent e){
			terminateAudio();
			if(e.getSource() == chooseTone) {
				
				selectedTone = (File) chooseTone.getSelectedItem();
				try {
					audio(selectedTone);
				} 
				catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
					}
				}
			if(e.getSource() == select) {
				finalTone = selectedTone;
				try {
					terminateAudio();
					audio(finalTone);
				} 
				catch (NullPointerException | UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					JOptionPane.showMessageDialog(null, "Please select an audio file");
				}
			}
		}
	}
	
	public static void main(String args[]) {
		try {
			audio(silentTone);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		new selectTone();
	}
}


