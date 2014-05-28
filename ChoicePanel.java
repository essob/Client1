package Client1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ChoicePanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel choice 		= new JPanel();
	private JButton onlyAI 		= new JButton("Spela mot datorn");
	private JButton twoHuman 	= new JButton("Två spelare");
	private JButton onlyHuman 	= new JButton("Fyra spelare");
	private ClientController controller;
	private ClientGUI gui;


	public ChoicePanel() {
	}

	public JPanel choiceButton() {
		choice.setPreferredSize(new Dimension(1000, 600));
		choice.setLayout(null);
		choice.setFont(new Font("Arial", Font.BOLD, 24));
		choice.setBackground(Color.GREEN.darker().darker());

		onlyAI.setBounds(200, 175, 150, 25);
		twoHuman.setBounds(350, 175, 150, 25);
		onlyHuman.setBounds(500, 175, 150, 25);

		choice.add(onlyAI, BorderLayout.CENTER);
		choice.add(twoHuman, BorderLayout.CENTER);
		choice.add(onlyHuman, BorderLayout.CENTER);

		onlyAI.addActionListener(this);
		twoHuman.addActionListener(this);
		onlyHuman.addActionListener(this);

		return choice;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == onlyAI) {
			controller.newRequest("newAIPlayer");
			gui.replaceGameBoard();
			//			controller.newRequest("newGame");

			//			controller.newRequest("newGame", true, false, false, false);
		}
		else if(e.getSource() == twoHuman) {
			//			controller.newRequest("newGame", true, true, false, false);
		}
		else if(e.getSource() == onlyHuman) {
		}


	}

	//	public static void main(String[] arg) {
	//		ChoicePanel chi = new ChoicePanel();
	//		chi.choiceButton();
	//	}
	public void setController(ClientController controller) {
		this.controller = controller;

	}
	public void setClientGUI(ClientGUI gui) {
		this.gui = gui;
	}
}
