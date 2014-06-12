package Client1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


/**
 * This class creates a textarea with a String containing info about sjuan.
 * @author Anna
 *
 */
public class AboutUs extends JFrame implements ActionListener{
	private JFrame frame = new JFrame("About us");
	private String content = "This software and related documentation are provided under a license" + 
			"\n" + "agreement containing restrictions on use and disclosure and are protected"  + 
			"\n" + "by intellectual property laws.  Except as expressly permitted in your license" + 
			"\n" + "agreement or allowed by law, you may not use, copy, reproduce, translate," + 
			"\n" + "broadcast, modify, license, transmit, distribute, exhibit, perform, publish," + 
			"\n" + "or display any part, in any form, or by any means. Reverse engineering," + 
			"\n" + "disassembly, or decompilation of this software, unless required by law for" + 
			"\n" + "interoperability, is prohibited." + 
			"\n" + 
			"\n" + "Copyright © 2014, Sjuan";
	private JTextArea textarea = new JTextArea(content);
	private JButton exitButton = new JButton("Avsluta");


	public AboutUs(){
		frame.setSize(510, 300);
		frame.setLocation(500, 200);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		textarea.setSize(300, 150);
		textarea.setBounds(40, 20, 550, 180);
		textarea.setEditable(false);
		textarea.setBackground(Color.white);	
		frame.add(textarea);


		exitButton.setSize(50, 50);
		//		exit.setLocation(50, 30);
		exitButton.setBounds(170, 200, 150, 25);
		frame.add(exitButton);
		exitButton.addActionListener(this);
		exitButton.setVisible(true);
		frame.setVisible(true);

	}

	public void close() {
		frame.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exitButton){
			frame.setVisible(false);
		}

	}
}