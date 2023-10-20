package projectFinal;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GUIProject extends Alarm implements guiFields {
    Container c = getContentPane();
    GUIProject() {
    	
    	timeFormat = new SimpleDateFormat("hh:mm:ss");
        setSize(800,700);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        c.setLayout(new BorderLayout());
        
        tasks.setLayout(new GridLayout(14,1));
        tasks.setPreferredSize(new Dimension(250,200));
        tasks.setBackground(new Color(201,255,229));
        c.add(tasks,BorderLayout.WEST);
        
        forTitle.setBackground(new Color(201,255,229));
        
        title.setForeground(new Color(120,120,120));
        title.setFont(new Font("Serif Bold Italic",Font.ROMAN_BASELINE,18));
        forTitle.add(title);
        
        tasks.add(forTitle);
        
        information.setLayout(new BorderLayout());
        information.setBackground(new Color(128,191,255));
        information.setPreferredSize(new Dimension(150,60));
        
        ourApp.setForeground(new Color(0,26,26));
        ourApp.setFont(new Font("Lucida Sans",Font.BOLD,18));
        information.add(ourApp,BorderLayout.EAST);
        
        mainArea.setLayout(new BorderLayout());
        
        Date.setLayout(new GridLayout(2,3));
        Date.setPreferredSize(new Dimension(300,100));
        Date.setBackground(new Color(179,204,255));
        mainArea.add(Date,BorderLayout.NORTH);
                
        hourLabel.setFont(new Font("Serif",Font.BOLD,15));
        minuteLabel.setFont(new Font("Serif",Font.BOLD,15));
        
        information.add(timeLabel,BorderLayout.NORTH);
        Date.add(hourLabel);
        Date.add(hour);
        Date.add(Snooze);
        Snooze.setIcon(forSnooze);
        Date.add(minuteLabel);
        Date.add(minute);
        Date.add(calendarBut);
        calendarBut.setIcon(forCalendar);
      
        userText.setFont(new Font("Times New Roman",Font.PLAIN,18));
        userText.setBackground(new Color(188,223,247));
        userText.setLineWrap(true);
        mainArea.add(userText,BorderLayout.CENTER);
        
        toDo.setFont(new Font("Times New Roman",Font.PLAIN,18));
        toDo.setBackground(new Color(240,248,255));
        toDo.setPreferredSize(new Dimension(200,300));
        
        toDo.setLineWrap(true);
        mainArea.add(toDo,BorderLayout.SOUTH);
        
        addTask.setFont(new Font("Times New Roman",Font.BOLD,16));
        addTask.setPreferredSize(new Dimension(200,40));
        c.add(addTask,BorderLayout.SOUTH);
        ImageIcon icon4 = new ImageIcon("tick.png");
        addTask.setIcon(icon4);
        
        sideBar.setLayout(new GridLayout(2,1));
        sideBar.setBackground(new Color(19,42,64));
        sideBar.setPreferredSize(new Dimension(180,120));
        mainArea.add(sideBar,BorderLayout.EAST);
        
        ImageIcon icon = new ImageIcon("set.png");
        settings.setFont(new Font("Times New Roman",Font.BOLD,13));
        settings.setIcon(icon);
        sideBar.add(settings);
              
        Border blackline = BorderFactory.createLineBorder(Color.black);
        tasks.setBorder(blackline);
        addTask.setBorder(blackline);
        information.setBorder(blackline);
        Date.setBorder(blackline);
        userText.setBorder(blackline);
        toDo.setBorder(blackline);
       
        sideBar.add(reset);
        ImageIcon icon3 = new ImageIcon("reset.png");
        reset.setIcon(icon3);
        reset.setFont(new Font("Times New Roman",Font.BOLD,13));
        
        c.add(information,BorderLayout.NORTH);
        c.add(mainArea, BorderLayout.CENTER);
       
        myAlarmListenerClass listener = new myAlarmListenerClass();
        
        settings.addActionListener(new Listener());
        addTask.addActionListener(new Listener());
        reset.addActionListener(new Listener());
        
        hour.addActionListener(listener);
        minute.addActionListener(listener);
        setAlarm.addActionListener(listener);
        Snooze.addActionListener(listener);
        calendarBut.addActionListener(listener);
       
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTime();
    }
    
    GUIProject(String setting) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setSize(350,100);
        setTitle("Change Alarmtone");
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(2,1));
 
        c.setBackground(new Color(179,204,255));
        c.setPreferredSize(new Dimension(120,20));
    
        c.add(chooseTone);
        c.add(Apply);
        
        chooseTone.addActionListener(new myselectToneListenerClass()); 
        Apply.addActionListener(new myselectToneListenerClass()); 
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(false);
    }

    private class Listener implements ActionListener {
       public void actionPerformed(ActionEvent e) {
    
            if (e.getSource()== settings) {
                GUIProject set = new GUIProject("settings");
                set.setVisible(true);
            }
            if (e.getSource() == addTask) {
            	
            	if(!(calButtonIsClicked)) {
            		JOptionPane.showMessageDialog(null , "Select a date please");
            	}
            	else {
            		
	            	calButtonIsClicked = false;
	            	setAlarm.doClick();  
	            	
	                JLabel label;
	                JButton delete = new JButton("Done");
	                delete.setBackground(new Color(68,204,0));
	                
	                String title = userText.getText();
	                JPanel panel1 = new JPanel();
	                panel1.setBackground(new Color(201,255,229));
	                label = new JLabel(title);
	                label.setFont(new Font("Times New Roman",Font.PLAIN,16));
	                panel1.add(label);
	                panel1.add(delete);
	                tasks.add(panel1);
	                
	                tasks.revalidate();
	                tasks.repaint();
	                
	                deletes.add(delete);
	                delete.addActionListener(new Listener2());
	                
	                titleText.add(userText.getText());
	                mainText.add(toDo.getText());
	                
	                timeElement.add(myAlarm + "$" + date);
	            	}
                }
            if (e.getSource() == reset) {
                userText.setText("set your title here.");
                toDo.setText("Any description");
                hour.setSelectedItem(hour.getItemAt(0));
                minute.setSelectedItem(minute.getItemAt(0));
            }
        } 
        private class Listener2 implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                boolean containsDeletes = deletes.contains(e.getSource());
                if(containsDeletes==true) {
                    int index = deletes.indexOf(e.getSource());
                    tasks.remove(index+1);
                    deletes.remove(index);
                    
                    tasks.revalidate();
                    tasks.repaint();
                }
            }
        }
    }
    
    private class myAlarmListenerClass extends AlarmListenerClass implements ActionListener{}
    private class myselectToneListenerClass extends selectToneListenerClass implements ActionListener{}
    
	public void setTime() {
		while(true) {
				
			myTime = timeFormat.format(Calendar.getInstance().getTime());
	        timeLabel.setText(myTime);
	        timeLabel.setFont(new Font("Serif",Font.BOLD,20));
	
	        if(timeElement.isEmpty()) {
	        	continue;
	        	}
	        
	        try {
		        if(timeElement.contains(myTime + "$" + nowDate)){
		      
		        	int indexOfTime = timeElement.indexOf(myTime + "$" + date);
		        	toDo.setText((String) mainText.get(indexOfTime));
		        	userText.setText((String) titleText.get(indexOfTime));
		        	
		        	decoyVariable = 1;
		        
					try {
						windowsNotify.main();
						audio(finalTone);
					} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
						e.printStackTrace();
					}
					timeElement.remove(myTime + "$" + nowDate);
		        }
	        }
	        catch(IndexOutOfBoundsException e) {}
	        try {
	        	Thread.sleep(1000);
	        }
	        catch(InterruptedException e){
	        	 e.printStackTrace();
	        }
		}
	}
    public static void main(String args[]) {
    	finalTone = selectedTone;
    	try {
			audio2(silentTone);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
        new GUIProject();
    }
}
