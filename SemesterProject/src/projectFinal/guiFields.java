package projectFinal;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public interface guiFields {
	
	JTextArea userText = new JTextArea("set your title here.");
	
	JLabel hourLabel = new JLabel("Set Hours");
	JLabel minuteLabel = new JLabel("Set Minutes");
	JLabel title = new JLabel("My To-do List");
	JLabel ourApp = new JLabel("Windows Reminder Application");
	 
	JPanel information = new JPanel();
	JPanel Date = new JPanel();
	JPanel tasks = new JPanel();
	JPanel mainArea = new JPanel();
	JPanel sideBar = new JPanel();
	JPanel forTitle = new JPanel();
	 
	JTextArea toDo = new JTextArea("Any description");
	   
	JButton addTask = new JButton("+ADD TASK+"); 
	JButton settings = new JButton("SETTINGS");
	JButton clearList = new JButton("CLEAR LIST");
	JButton reset = new JButton("RESET"); 
	       
	     
	ArrayList deletes = new ArrayList();
	ArrayList titleText = new ArrayList();
	ArrayList mainText = new ArrayList();
	  
	ArrayList timeElement = new ArrayList();
	          
	String setting = "";
	 
	JLabel soundDescription = new JLabel("Alarm Sound");
}


