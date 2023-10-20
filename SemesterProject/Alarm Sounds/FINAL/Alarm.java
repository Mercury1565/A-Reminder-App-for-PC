package FINAL;
import com.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.sound.sampled.*;
import javax.swing.*;
//import sun.audio.*;
/*Things I haven't achived;
	 *Snooze button
	 *Choosing my ringing tone
	 *Selecting the date from a calendarw
 */

public class Alarm extends ToggleButton{
	
	String myAlarm;
	String myTime;
	
	Calendar calendar;
	SimpleDateFormat timeFormat;
	
	String[] minutes = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19",
			"20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39",
			"40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59",
			};
	String[] hours = {"01","02","03","04","05","06","07","08","09","10","11","12"};
	
	JComboBox hour = new JComboBox(hours);
	JComboBox minute = new JComboBox(minutes);
	
	JLabel timeLabel = new JLabel();
	JLabel upcomingAlarm = new JLabel();
	
	JButton setAlarm = new JButton("Set alarm");
	JButton Snooze = new JButton("Snooze");
	
	public Alarm(){
		Container c = getContentPane();
		setLocation(200,200);
		setSize(400,400);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        c.setLayout(new GridLayout(7,1));
        
        timeFormat = new SimpleDateFormat("hh:mm:ss");
             
        c.add(timeLabel);
        c.add(upcomingAlarm);
        
        c.add(hour);
        c.add(minute);
        c.add(setAlarm);
        c.add(Snooze);
        c.add(toggleButton);
               
        Il ActionListner = new Il();
        hour.addActionListener(ActionListner);
        minute.addActionListener(ActionListner);
        setAlarm.addActionListener(ActionListner);
        Snooze.addActionListener(ActionListner);
        toggleButton.addItemListener(itemListener);
        
        setVisible(true);
        ActionListner.setTime();
        }
	
	File file = new File("rolling-tone.wav");
	
	private class Il implements ActionListener{
		
		static AudioInputStream audioStream;
		static Clip clip;
		public static void audio(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
			
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip(); 
			clip.open(audioStream);
			clip.loop(5);
			}
		public static void terminateAudio() {
			clip.close();
		}
		
		public void setTime() {
			while(true) {
				myTime = timeFormat.format(Calendar.getInstance().getTime());
		        timeLabel.setText(myTime);
		        if(timeLabel.getText().equals(myAlarm)){
	            	upcomingAlarm.setText("IT IS TIME !!!");
	            		try {
							audio(file);
						} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
	        	}
		        try {
		        	Thread.sleep(1000);
		        }
		        catch(InterruptedException e){
		        	 e.printStackTrace();
		        }
			}
		}
		
		String hourString;
		String minuteString = "00:00";
		String alarmString;
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==hour){
            	alarmString = "";
            	hourString = "";
            	hourString += (hour.getSelectedItem() + ":" );
            	alarmString += hourString + minuteString;
            }
            
            if(e.getSource() == minute){
            	alarmString = "";
            	minuteString = "";
            	minuteString += (minute.getSelectedItem() + ":00");
            	alarmString += hourString + minuteString;
        		}
            if(e.getSource() == setAlarm) {
            	myAlarm = alarmString;
        		upcomingAlarm.setText("Upcoming alarm at  " + alarmString);
            }
            if(e.getSource() == Snooze){
					terminateAudio();
				}
            }
        }
	public static void main(String Args[]) {
		new Alarm();
	}
}
