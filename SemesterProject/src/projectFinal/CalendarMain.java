package projectFinal;


import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class CalendarMain extends JFrame implements PropertyChangeListener {
	String dateString;
	String nowDate;
	
	private static final long serialVersionUID = 1L;

	JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
	
	public static void main(String[] args){
		
		calendar date = new calendar();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CalendarMain window = null;
			
				try {
					window = new CalendarMain();
					window.setVisible(true);
					
				}
				catch (Exception exp) {
					exp.printStackTrace();
				}
				
			}
			
		});
	}
		
		public CalendarMain(){
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(368, 362);
			setTitle("MindFusion.Scheduling Sample: Minimal Application");
			
			Container cp = getContentPane();
			FlowLayout flowLayout = new FlowLayout();
			
			cp.setLayout(flowLayout);			
			 	
			textField.setValue(new Date());
			nowDate = textField.getText();
			
			textField.setPreferredSize(new Dimension(130, 30));
			    
			calendar calendarWindow = new calendar(); 
			 
			calendarWindow.addPropertyChangeListener(this);
			
			JButton setDate = new JButton("Set date");
			JButton calendarButton = new JButton("Pick a Date");
					
			calendarButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e){
				
				calendarWindow.setLocation(textField.getLocationOnScreen().x, (textField.getLocationOnScreen().y + textField.getHeight()));
				Date d = (Date)textField.getValue();
				
				calendarWindow.resetSelection(d);				
				calendarWindow.setUndecorated(true);
			    calendarWindow.setVisible(true);
			  }
			});
			
			setDate.addActionListener(new ActionListener()
					{public void actionPerformed(ActionEvent e)
					  {
						dateString = textField.getText();
						setVisible(false);
					  }
				});

			cp.add(textField);
			cp.add(calendarButton);
			cp.add(setDate);
			cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	
		}

		public void propertyChange(PropertyChangeEvent event) {
		
			if (event.getPropertyName().equals("selectedDate")) {
	            
				java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
				Date selDate =  cal.getTime();
				textField.setValue(selDate);
				dateString = selDate.toString();
	        }
		}
		
}
