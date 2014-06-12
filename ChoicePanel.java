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
	private JButton btnThreeHuman 	= new JButton("Tre spelare");
	private JButton btnOnlyHuman 	= new JButton("Fyra spelare");
	private ClientController controller;
	private ClientGUI gui;

	public JPanel choiceButton() {
		pnlChoice.setPreferredSize(new Dimension(1000, 600));
		pnlChoice.setLayout(null);
		pnlChoice.setFont(new Font("Arial", Font.BOLD, 24));
		pnlChoice.setBackground(Color.GREEN.darker().darker());

		btnOnlyAI.setBounds(150, 175, 150, 25);
		btnTwoHuman.setBounds(300, 175, 150, 25);
		btnThreeHuman.setBounds(450, 175, 150, 25);
		btnOnlyHuman.setBounds(600, 175, 150, 25);

		pnlChoice.add(btnOnlyAI, BorderLayout.CENTER);
		pnlChoice.add(btnTwoHuman, BorderLayout.CENTER);
		pnlChoice.add(btnThreeHuman, BorderLayout.CENTER);
		pnlChoice.add(btnOnlyHuman, BorderLayout.CENTER);

		btnOnlyAI.addActionListener(this);
		btnTwoHuman.addActionListener(this);
		btnThreeHuman.addActionListener(this);
		btnOnlyHuman.addActionListener(this);

		return pnlChoice;

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		if(e.getSource() == btnOnlyAI) {
			controller.newRequest("newAIPlayer");
			btnOnlyAI.setVisible(false);
			btnTwoHuman.setVisible(false);
			btnThreeHuman.setVisible(false);
			btnOnlyHuman.setVisible(false);
			gui.replaceGameBoard();

		}

		else if(e.getSource() == btnTwoHuman) {
			controller.newRequest("twoPlayerGame");
			btnOnlyAI.setVisible(false);
			btnTwoHuman.setVisible(false);
			btnThreeHuman.setVisible(false);
			btnOnlyHuman.setVisible(false);
			gui.replaceGameBoard();
			gui.setInstructions("Invänta fler klienter till att ansluta till spelet");
		}

		else if(e.getSource() == btnThreeHuman) {
			controller.newRequest("threePlayerGame");
			btnOnlyAI.setVisible(false);
			btnTwoHuman.setVisible(false);
			btnThreeHuman.setVisible(false);
			btnOnlyHuman.setVisible(false);
			gui.replaceGameBoard();
			gui.setInstructions("Invänta fler klienter till att ansluta till spelet");

		}

		else if(e.getSource() == btnOnlyHuman) {
			controller.newRequest("fourPlayerGame");
			btnOnlyAI.setVisible(false);
			btnTwoHuman.setVisible(false);
			btnThreeHuman.setVisible(false);
			btnOnlyHuman.setVisible(false);
			gui.replaceGameBoard();
			gui.setInstructions("Invänta fler klienter till att ansluta till spelet");

		}
	}

	public void setController(ClientController controller) {
		this.controller = controller;

	}
	public void setClientGUI(ClientGUI gui) {
		this.gui = gui;
	}
	public void showButtons() {
		btnOnlyAI.setVisible(true);
		btnTwoHuman.setVisible(true);
		btnThreeHuman.setVisible(true);
		btnOnlyHuman.setVisible(true);
	}

	public void showPanel() {
		pnlChoice.setVisible(true);
		showButtons();
	}
}
