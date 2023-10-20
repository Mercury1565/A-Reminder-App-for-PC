package FINAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyReminder extends JFrame {
	String[] items = {"Hermon" , "Fenet"};
	private JComboBox jb = new JComboBox(items);; 
	//private JToggleButton("ON");
    private JButton b1;
    private JButton b2;
    private JPanel p1;
    private JPanel p2;
    private JLabel l1;
    private JTextField f1;
    MyReminder() {
        super("This is a simple reminder app.");
        Container c = getContentPane();
        setLocation(200,200);
        setSize(400,400);
       // c.setLayout(null);
        c.setBackground(new Color(210,210,210));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        p1 = new JPanel();
        p2 = new JPanel();
        l1 = new JLabel("this is sparta");
        f1 = new JTextField("this is basic");
        
        p1.setBackground(new Color(150,2,240));
        p2.setBackground(new Color(15,120,120));
        
        l1.setBounds(0,0,150,400);
        f1.setBounds(150,0,250,300);
        p1.setBounds(150,300,250,100);
        
        b1 = new JButton("click here");
        b2 = new JButton("click here");
        b2.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);

        c.add(jb);
       // c.add(f1);
        //c.add(p1);
        //c.add(jb);
        
        pack();
        
       /* p1.add(b1);
        p2.add(jb);*/
        setVisible(true);
        //b1.addActionListener(new Il());
        jb.addActionListener(new Il());
    }
    
        private class Il implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==b1){
                	String text = f1.getText();
                	l1.setText(text);
                	f1.setText("");
                	}
                if(e.getSource() == jb) {
                	System.out.println("hELLO");
                }
            }
       }
    
    public static void main(String args[]) {
        new MyReminder();
    }
    
}

