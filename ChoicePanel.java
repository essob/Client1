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
	private JPanel pnlChoice 		= new JPanel();
	private JButton btnOnlyAI 		= new JButton("Spela mot datorn");
	private JButton btnTwoHuman 	= new JButton("Två spelare");
	private JButton btnOnlyHuman 	= new JButton("Fyra spelare");
	private ClientController controller;


	public ChoicePanel() {
	}

	public JPanel choiceButton() {
		pnlChoice.setPreferredSize(new Dimension(1000, 600));
		pnlChoice.setLayout(null);
		pnlChoice.setFont(new Font("Arial", Font.BOLD, 24));
		pnlChoice.setBackground(Color.GREEN.darker().darker());

		btnOnlyAI.setBounds(200, 175, 150, 25);
		btnTwoHuman.setBounds(350, 175, 150, 25);
		btnOnlyHuman.setBounds(500, 175, 150, 25);
		
		pnlChoice.add(btnOnlyAI, BorderLayout.CENTER);
		pnlChoice.add(btnTwoHuman, BorderLayout.CENTER);
		pnlChoice.add(btnOnlyHuman, BorderLayout.CENTER);
		
		btnOnlyAI.addActionListener(this);
		btnTwoHuman.addActionListener(this);
		btnOnlyHuman.addActionListener(this);
		
		return pnlChoice;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOnlyAI) {
			controller.newRequest("newAIPlayer");
//			controller.newRequest("newGame");

			//			controller.newRequest("newGame", true, false, false, false);
		}
		else if(e.getSource() == btnTwoHuman) {
			//			controller.newRequest("newGame", true, true, false, false);
		}
		else if(e.getSource() == btnOnlyHuman) {
		}


	}

	//	public static void main(String[] arg) {
	//		ChoicePanel chi = new ChoicePanel();
	//		chi.choiceButton();
	//	}
	public void setController(ClientController controller) {
		this.controller = controller;
		
	}


}
