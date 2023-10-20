package FINAL;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class ToggleButton{
	Color color;
	protected JToggleButton toggleButton = new JToggleButton("Toggle Button");
	protected ItemListener itemListener = new ItemListener() {
		public void itemStateChanged(ItemEvent itemEvent){
			int state = itemEvent.getStateChange();
			
			if (state == ItemEvent.SELECTED) {
				color = new Color(255,255,255);
				System.out.println("Selected");
			}
			else {
				color = new Color(0,0,0);
				System.out.println("Deselected");
				}
			}
	};
}
