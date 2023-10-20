package projectFinal;
import com.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.ImageIcon.*;

public class Alarm extends selectTone implements guiFields{
	ArrayList reminderDate = new ArrayList();

	Boolean calButtonIsClicked = false;
	
	CalendarMain x;
	
	String date;
	String nowDate;
	String myAlarm;
	String myTime;
	
	Calendar calendar;
	SimpleDateFormat timeFormat;
	
	String[] minutes = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19",
			"20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39",
			"40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59",
			};
	protected String[] hours = {"00","01","02","03","04","05","06","07","08","09","10","11","12"};
	
	protected JComboBox hour = new JComboBox(hours);
	protected JComboBox minute = new JComboBox(minutes);
	
	int decoyVariable = 0;
	JLabel timeLabel = new JLabel();
	
	JButton calendarBut = new JButton("Set date");
	ImageIcon forCalendar = new ImageIcon("calendar.png");
	JButton setAlarm = new JButton("Set alarm");
	
	JButton Snooze = new JButton("Snooze");
	ImageIcon forSnooze = new ImageIcon("snooze.png");
	
	public class AlarmListenerClass  {
		
		
		String hourString;
		String minuteString = "00:00";
		String alarmString = "";
		
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
            
            if(e.getSource() == calendarBut) {
            	calButtonIsClicked = true;
            	x = new CalendarMain();
            	x.setVisible(true);
            	}
            
            if(e.getSource() == setAlarm) {
            	
            	if(alarmString.equals("")) {
            		alarmString = "00:00:00";
            	}
            	nowDate = x.nowDate;
            	myAlarm = alarmString;
        		date = x.nowDate;
        		date = x.dateString;
            	
            }
            if(e.getSource() == Snooze){
            	try {
            		int num = 2 / decoyVariable;
            		terminateAudio();
            	}
            	catch(ArithmeticException e2) {}
            	}
           }
        }
	class selectToneListenerClass extends selectToneListener{}
	
	static AudioInputStream audioStream;
	static Clip clip;
	public static void audio(File file) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip(); 
		clip.open(audioStream);
		clip.loop(15);
		}
	public static void terminateAudio() {
		clip.close();
    }
	
	public void setTime() {
		while(true) {
			myTime = timeFormat.format(Calendar.getInstance().getTime());
	        timeLabel.setText(myTime);
	        timeLabel.setFont(new Font("Serif",Font.BOLD,20));
	        if(timeLabel.getText().equals(myAlarm) && date == nowDate){
	        	
	        	decoyVariable = 1;
				try {
					audio(finalTone);
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
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
}
