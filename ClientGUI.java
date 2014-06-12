
package Client1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import sjuan.Card;

import com.mysql.jdbc.ResultSetMetaData;

import java.util.ArrayList;


/**
 * This class generates a Grafical User Interface to play the game
 */
public class ClientGUI extends JPanel implements ActionListener{

	private JPanel gameBoardPanel = new JPanel();
	private ClientController controller;
	private JFrame gameFrame = new JFrame("Sjuan");
	private PlayersPanel pPnlPlay = new PlayersPanel(this);
	private ChoicePanel cPnlChoice = new ChoicePanel();
	private JPanel pnlGameBoard = new JPanel();
	private JPanel pnlPlayer = new JPanel();
	private JPanel pnlOpponent1 = new JPanel();
	private JPanel pnlOpponent2 = new JPanel();
	private JPanel pnlOpponent3 = new JPanel();
	private JPanel pnlOptions = new JPanel();
	private JPanel pnlLeftOptions = new JPanel();
	private JPanel pnlRightOptions = new JPanel();
	//	private JButton btnReady = new JButton("Inställningar");
	private JButton btnPass = new JButton("Pass");
	private JButton btnEnd = new JButton("Avsluta spel");
	//	private JButton btnDatabas = new JButton("Statistik");
	private JButton aboutUs = new JButton("About us"); 


	private PlayLabel pLbl = new PlayLabel(this);
	private JLabel lblInstructions = new JLabel("Det är din tur");
	private JLabel lblOp1Number = new JLabel("13");
	private JLabel lblOp2Number = new JLabel("13");
	private JLabel lblOp3Number = new JLabel("13");

	/**
	 * Constructs the Gui
	 */
	public ClientGUI(ClientController controller, String userName) {
		this.controller = controller;
		GamePanel();
		setGameFrameTitle(userName);
		cPnlChoice.setController(this.controller);
		cPnlChoice.setClientGUI(this);
	}

	/**
	 * This Method creates the Gui Frame
	 */
	public void GamePanel(){
		gameFrame.setBounds(40, 200, 1100, 600);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(cPnlChoice.choiceButton());
		gameFrame.add(playerPanel(), BorderLayout.SOUTH);
		gameFrame.add(opponent1Panel(), BorderLayout.WEST);
		gameFrame.add(pnlOptions, BorderLayout.NORTH);
		gameFrame.add(opponent3Panel(), BorderLayout.EAST);

		pnlOptions.setBackground(Color.MAGENTA.darker().darker());
		pnlOptions.add(leftOptionsPanel(), BorderLayout.WEST);
		pnlOptions.add(opponent2Panel(), BorderLayout.CENTER);
		pnlOptions.add(rightOptionsPanel(), BorderLayout.EAST);

		btnEnd.addActionListener(this);
		btnPass.addActionListener(this);
		//		btnDatabas.addActionListener(this);
		aboutUs.addActionListener(this);
		//		btnReady.addActionListener(this);

		gameFrame.setVisible(true);

	}

	public void replaceGameBoard() {
		gameFrame.remove(cPnlChoice);
		gameFrame.add(gameBoardPanel(), BorderLayout.CENTER);

	}

	public void replaceChoicePanel() {
		gameFrame.remove(pnlGameBoard);
		gameFrame.add(choicePanel(), BorderLayout.CENTER);

	}

	/**
	 * This method returns a panel
	 * @return panel returns a panel
	 */
	public JPanel gameBoardPanel() {
		pnlGameBoard.removeAll();
		pnlGameBoard.setLayout(null);
		pnlGameBoard.setFont(new Font("Arial", Font.BOLD, 24));
		pnlGameBoard.setBackground(Color.GREEN.darker().darker());
		lblInstructions.setBounds(10, 340, 700, 20);
		pnlGameBoard.add(lblInstructions);

		return pnlGameBoard;	
	}

	public JPanel choicePanel() {
		cPnlChoice = new ChoicePanel();
		cPnlChoice.setLayout(null);
		cPnlChoice.setFont(new Font("Arial", Font.BOLD, 24));
		cPnlChoice.setBackground(Color.GREEN.darker().darker());
		//		cPnlChoice.showPanel();

		return cPnlChoice;	
	}


	public void setCardAtGameBoard(Card card) {
		pnlGameBoard.add(pLbl.findOutWhere(card));
	}

	/**
	 * This method returns a panel to represent the actual player panel
	 * @return player1Panel return the actual player panel
	 */
	public JPanel playerPanel() {
		pnlPlayer = pPnlPlay.getPanel();
		return pnlPlayer;
	}

	/**
	 * this method sets the players cards in gui
	 * @param cards takes in the players cards
	 */
	public void setPlayersCardsInGUI(ArrayList<Card> cards) {
		pPnlPlay.setPlayersCardsInGUI(cards);
		pPnlPlay.addCardListener(cards);
		updateAllPanels();
	}

	public JPanel leftOptionsPanel() {
		pnlLeftOptions.setPreferredSize(new Dimension(150, 100));
		pnlLeftOptions.setBackground(Color.MAGENTA.darker().darker());
		//		pnlLeftOptions.add(btnDatabas);
		//		pnlLeftOptions.add(btnReady);
		return pnlLeftOptions;

	}

	public JPanel rightOptionsPanel() {
		pnlRightOptions.setPreferredSize(new Dimension(150, 100));
		pnlRightOptions.setBackground(Color.MAGENTA.darker().darker());
		pnlRightOptions.add(btnPass);
		pnlRightOptions.add(aboutUs);
		pnlRightOptions.add(btnEnd);
		return pnlRightOptions;
	}

	/**
	 * This method returns a panel to represent the opponent1
	 * @return opponent1Panel return a panel of opponent1
	 */
	public JPanel opponent1Panel() {
		pnlOpponent1.setPreferredSize(new Dimension(100, 200));
		pnlOpponent1.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		pnlOpponent1.setBackground(Color.BLUE.darker());

		return pnlOpponent1;
	}

	/**
	 * this method sets amount of cards in opponent1s panel
	 * @param nbr takes in the amount of cards in opponent1s hand
	 */
	public void setNbrOfOpponent1Cards (int nbr) {
		pnlOpponent1.removeAll();
		lblOp1Number.setText(nbr + "");
		pnlOpponent1.add(lblOp1Number);
		JLabel opponent1Cards = null;

		if (nbr != 0) {
			for (int i = 0; i < nbr; i++) {
				opponent1Cards = new JLabel();
				if (i==0)
					opponent1Cards.setIcon(readFiles("b1fh"));
				else
					opponent1Cards.setIcon(readFiles("b1pb"));
				pnlOpponent1.add(opponent1Cards);

			}
		}
	}
	/**
	 * This method returns a panel to represent the opponent2
	 * @return opponent1Panel return a panel of opponent2
	 */
	public JPanel opponent2Panel() {
		pnlOpponent2.setPreferredSize(new Dimension(750, 100));
		pnlOpponent2.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		pnlOpponent2.setBackground(Color.MAGENTA.darker().darker());

		return pnlOpponent2;
	}

	/**
	 * this method sets amount of cards in opponent2s panel
	 * @param nbr takes in the amount of cards in opponent2s hand
	 */
	public void setNbrOfOpponent2Cards (int nbr) {
		pnlOpponent2.removeAll();
		lblOp2Number.setText(nbr + "");
		pnlOpponent2.add(lblOp2Number);
		JLabel opponent2Cards = null;

		if (nbr != 0)
			for (int i = 0; i < nbr; i++) {
				opponent2Cards = new JLabel();
				if (i==0)
					opponent2Cards.setIcon(readFiles("b1fv"));
				else
					opponent2Cards.setIcon(readFiles("b1pr"));
				pnlOpponent2.add(opponent2Cards);
			}
	}

	/**
	 * This method returns a panel to represent the opponent3
	 * @return opponent1Panel return a panel of opponent3
	 */
	public JPanel opponent3Panel() {
		pnlOpponent3.setPreferredSize(new Dimension(100, 200));
		pnlOpponent3.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		pnlOpponent3.setBackground(Color.ORANGE);


		return pnlOpponent3;
	}
	/**
	 * this method sets amount of cards in opponent3s panel
	 * @param nbr takes in the amount of cards in opponent3s hand
	 */
	public void setNbrOfOpponent3Cards (int nbr) {
		pnlOpponent3.removeAll();
		lblOp3Number.setText(nbr + "");
		pnlOpponent3.add(lblOp3Number);
		JLabel opponent3Cards = null;

		if (nbr != 0)
			for (int i = 0; i < nbr-1; i++) {
				opponent3Cards = new JLabel();
				opponent3Cards.setIcon(readFiles("b1pt"));
				pnlOpponent3.add(opponent3Cards);
			}
		if (nbr != 0) {
			opponent3Cards = new JLabel();
			opponent3Cards.setIcon(readFiles("b1fh"));
			pnlOpponent3.add(opponent3Cards);
		}

	}

	/**
	 * This metod reads a picture file and return it as a Icon Object
	 * @return icon returns a Icon Object
	 */
	public ImageIcon readFiles(String str) {
		return new ImageIcon("src/sjuan/files/cards_png/" + str +".png");
	}

	/**
	 * this method updates the graphics of all panels
	 */
	public void updateAllPanels() {
		pnlPlayer.updateUI();
		pnlOpponent1.updateUI();
		pnlOpponent2.updateUI();
		pnlOpponent3.updateUI();
		pnlGameBoard.updateUI();
		choicePanel().updateUI();
		cPnlChoice.updateUI();

	}

	public void setGameFrameTitle(String userName) {
		gameFrame.setTitle(userName);
	}

	/**
	 *	this method makes cards clickable 
	 */

	public void addCardAction(ArrayList<Card> cards){
		pPnlPlay.addCardListener(cards);
	}

	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btnEnd) {
			System.exit(0);
		}
		else if(e.getSource() == btnPass){
			controller.newRequest("pass", null, 0);
		}
		//		else if(e.getSource()==btnDatabas){
		//			controller.newRequest("database", gameFrame.getTitle(), null);
		//		}
		//		else if(e.getSource() == btnReady) {
		//			JOptionPane.showMessageDialog(null, "Under konstruktion...");
		//		}
		else if(e.getSource() == aboutUs) {
			new AboutUs();
		}
	}
	/**
	 * this method play a card from a hand to the gameboard
	 * @param cardName takes in a string of a cards name
	 */
	public void playCard(String cardName) {
		controller.giveOrPlay(cardName);

	}
	public void dimAll() {
		//		start.setEnabled(false);
		btnPass.setEnabled(false);
		//		btnDatabas.setEnabled(false);
		//		btnReady.setEnabled(false);
		aboutUs.setEnabled(true);
		pPnlPlay.removeCardListener();
		pPnlPlay.dimAllCards();
		lblInstructions.setText("Vänta på att de andra spelarna gör sitt drag");

	}
	public void dimAllExceptStart() {
		btnPass.setEnabled(false);
		//		btnDatabas.setEnabled(false);
		//		btnReady.setEnabled(false);
		aboutUs.setEnabled(true);
		pPnlPlay.removeCardListener();
		pPnlPlay.dimAllCards();
		lblInstructions.setText("Klicka på Börja Spelomgång och invänta andra spelare att logga in!");
	}

	public void unDimAll() {
		btnEnd.setEnabled(true);
		btnPass.setEnabled(true);
		//		btnDatabas.setEnabled(true);
		pPnlPlay.unDimAllCards();
		lblInstructions.setText("Det är din tur");
	}

	public void setInstructions(String instuctions) {
		lblInstructions.setText(instuctions);
	}

	public void setOpNumber(String number) {
		lblOp1Number.setText(number);
		lblOp2Number.setText(number);
		lblOp3Number.setText(number);
	}	
}
