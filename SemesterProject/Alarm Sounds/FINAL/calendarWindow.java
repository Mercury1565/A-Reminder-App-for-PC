package FINAL;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;


import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

import com.*;
import com.mindfusion.common.DateTime;
import com.mindfusion.scheduling.Calendar;
import com.mindfusion.scheduling.ThemeType;
import com.mindfusion.common.*;
import com.mindfusion.scheduling.ThemeType;

public class calendarWindow extends JFrame {	
	
    private static final long serialVersionUID = 1L;	
		
	java.util.Calendar selectedDate = java.util.Calendar.getInstance();
	Calendar calendar = new Calendar();
	protected PropertyChangeSupport changeSupport;

	public calendarWindow()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);	    
		
		//setSize(235, 200);
		//setTitle("MindFusion.Scheduling Sample: Minimal Application");
		
		changeSupport = new PropertyChangeSupport(this);
		calendar.setTheme(ThemeType.Light);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(calendar, BorderLayout.CENTER);
				calendar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2)
				{			
					//clear the selection
					calendar.getSelection().reset();
					//get the date that was double-clicked
					DateTime pointedDate = calendar.getDateAt( e.getX(), e.getY());
					//create a java.util.Calendar instance that points to the selected Date
					java.util.Calendar cal = java.util.Calendar.getInstance();
					cal.set(pointedDate.getYear(), pointedDate.getMonth() - 1, pointedDate.getDay());
					//raise the event
					setSelectedDate(cal);					
 
					dispose();						
								}
					}
		});	
			}
		public java.util.Calendar getSelectedDate()
	{
		return selectedDate;
		}
		public void resetSelection(Date date)
	{
		calendar.getSelection().reset();
		calendar.getSelection().set(new DateTime(date), new DateTime(date).addMinutes(2));
		calendar.setDate(new DateTime(date));
			}
		public void setSelectedDate (java.util.Calendar selDate)
	{
		java.util.Calendar oldValue = (java.util.Calendar)selectedDate.clone();
		selectedDate = selDate;				
				
		changeSupport.firePropertyChange("selectedDate",oldValue, selectedDate);
			}
		 public void addPropertyChangeListener(PropertyChangeListener listener) {
		 changeSupport.addPropertyChangeListener(listener);
	    }
	}

    

