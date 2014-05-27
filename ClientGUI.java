
package Client1;

import java.awt.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.jdbc.ResultSetMetaData;

import java.util.ArrayList;
import sjuan.Card;


/**
 * This class generates a Grafical User Interface to play the game
 */
public class ClientGUI extends JPanel implements ActionListener{
	private JPanel gameBoardPanel = new JPanel();
	private JFrame gameFrame = new JFrame("Sjuan");
	private JPanel playerPanel = new JPanel();
	private JPanel opponent1Panel = new JPanel();
	private JPanel opponent2Panel = new JPanel();
	private JPanel opponent3Panel = new JPanel();
	private JPanel optionsPanel = new JPanel();
	private LoginFrame LoginFrame;
	private JPanel leftOptionsPanel = new JPanel();
	private JPanel rightOptionsPanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	private JButton ready = new JButton("???");
	private JButton pass = new JButton("Pass");
	private JButton end = new JButton("Avsluta spel");
	private StartButton start = new StartButton("Börja spelomgång");
	private JButton aboutUs = new JButton("About us"); 
	private JButton databas = new JButton("Databas");
	private ClientController controller;
	private PlayLabel pLabel = new PlayLabel(this);
	private PlayersPanel play = new PlayersPanel(this);
	


	/**
	 * Constructs the Gui
	 */
	public ClientGUI(ClientController controller, int clientID) {
		this.controller = controller;
		GamePanel();
		setGameFrameTitle(clientID);
	}

	/**
	 * This Method creates the Gui Frame
	 */
	public void GamePanel(){
		gameFrame.setBounds(40, 200, 1100, 600);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(gameBoardPanel(), BorderLayout.CENTER);
		gameFrame.add(playerPanel(), BorderLayout.SOUTH);
		gameFrame.add(opponent1Panel(), BorderLayout.WEST);
		gameFrame.add(optionsPanel, BorderLayout.NORTH);
		gameFrame.add(opponent3Panel(), BorderLayout.EAST);

		optionsPanel.setBackground(Color.MAGENTA.darker().darker());
		optionsPanel.add(leftOptionsPanel(), BorderLayout.WEST);
		optionsPanel.add(opponent2Panel(), BorderLayout.CENTER);

		optionsPanel.add(rightOptionsPanel(), BorderLayout.EAST);

		start.addActionListener(this);
		end.addActionListener(this);
		pass.addActionListener(this);
		databas.addActionListener(this);
		aboutUs.addActionListener(this);
		ready.addActionListener(this);
		gameFrame.setVisible(true);


	}

	/**
	 * This method returns a panel
	 * @return panel returns a panel
	 */
	public JPanel gameBoardPanel() {
		gameBoardPanel.setLayout(null);
		gameBoardPanel.setFont(new Font("Arial", Font.BOLD, 24));
		gameBoardPanel.setBackground(Color.GREEN.darker().darker());

		return gameBoardPanel;	
	}


	public void setCardAtGameBoard(Card card) {
		gameBoardPanel.add(pLabel.findOutWhere(card));
	}

	/**
	 * This method returns a panel to represent the actual player panel
	 * @return player1Panel return the actual player panel
	 */
	public JPanel playerPanel() {
		playerPanel = play.getPanel();
		return playerPanel;
	}


	/**
	 * this method sets the players cards in gui
	 * @param cards takes in the players cards
	 */
	public void setPlayersCardsInGUI(ArrayList<Card> cards) {
		play.setPlayersCardsInGUI(cards);
		updateAllPanels();
	}

	public JPanel leftOptionsPanel() {
		leftOptionsPanel.setPreferredSize(new Dimension(150, 100));
		leftOptionsPanel.setBackground(Color.MAGENTA.darker().darker());
		leftOptionsPanel.add(pass);
		leftOptionsPanel.add(databas);
		leftOptionsPanel.add(aboutUs);
		return leftOptionsPanel;
	}

	public JPanel rightOptionsPanel() {
		rightOptionsPanel.setPreferredSize(new Dimension(150, 100));
		rightOptionsPanel.setBackground(Color.MAGENTA.darker().darker());
		rightOptionsPanel.add(start);
		rightOptionsPanel.add(ready);
		rightOptionsPanel.add(end);
		return rightOptionsPanel;
	}

	/**
	 * This method returns a panel to represent the opponent1
	 * @return opponent1Panel return a panel of opponent1
	 */
	public JPanel opponent1Panel() {
		opponent1Panel.setPreferredSize(new Dimension(100, 200));
		opponent1Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent1Panel.setBackground(Color.BLUE.darker());

		return opponent1Panel;
	}

	/**
	 * this method sets amount of cards in opponent1s panel
	 * @param nbr takes in the amount of cards in opponent1s hand
	 */
	public void setNbrOfOpponent1Cards (int nbr) {
		opponent1Panel.removeAll();
		JLabel opponent1Cards = null;
		if (nbr != 0) {
			for (int i = 0; i < nbr; i++) {
				opponent1Cards = new JLabel();
				if (i==0)
					opponent1Cards.setIcon(readFiles("b1fh"));
				else
					opponent1Cards.setIcon(readFiles("b1pb"));
				opponent1Panel.add(opponent1Cards);
			}
		}
	}
	/**
	 * This method returns a panel to represent the opponent2
	 * @return opponent1Panel return a panel of opponent2
	 */
	public JPanel opponent2Panel() {
		opponent2Panel.setPreferredSize(new Dimension(750, 100));
		opponent2Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent2Panel.setBackground(Color.MAGENTA.darker().darker());

		return opponent2Panel;
	}

	/**
	 * this method sets amount of cards in opponent2s panel
	 * @param nbr takes in the amount of cards in opponent2s hand
	 */
	public void setNbrOfOpponent2Cards (int nbr) {
		opponent2Panel.removeAll();
		JLabel opponent2Cards;
		if (nbr != 0)
			for (int i = 0; i < nbr; i++) {
				opponent2Cards = new JLabel();
				if (i==0)
					opponent2Cards.setIcon(readFiles("b1fv"));
				else
					opponent2Cards.setIcon(readFiles("b1pr"));
				opponent2Panel.add(opponent2Cards);
			}
	}

	/**
	 * This method returns a panel to represent the opponent3
	 * @return opponent1Panel return a panel of opponent3
	 */
	public JPanel opponent3Panel() {
		opponent3Panel.setPreferredSize(new Dimension(100, 200));
		opponent3Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent3Panel.setBackground(Color.ORANGE);

		return opponent3Panel;
	}
	/**
	 * this method sets amount of cards in opponent3s panel
	 * @param nbr takes in the amount of cards in opponent3s hand
	 */
	public void setNbrOfOpponent3Cards (int nbr) {
		opponent3Panel.removeAll();
		JLabel opponent3Cards;
		if (nbr != 0)
			for (int i = 0; i < nbr-1; i++) {
				opponent3Cards = new JLabel();
				opponent3Cards.setIcon(readFiles("b1pt"));
				opponent3Panel.add(opponent3Cards);
			}
		opponent3Cards = new JLabel();
		opponent3Cards.setIcon(readFiles("b1fh"));
		opponent3Panel.add(opponent3Cards);
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
		playerPanel.updateUI();
		opponent1Panel.updateUI();
		opponent2Panel.updateUI();
		opponent3Panel.updateUI();
		gameBoardPanel.updateUI();



	}
	/**
	 * this method makes start button disabled
	 */
	public void startButtonDimmed() {
		start.setEnabled(false);

	}
	/**
	 * this method sets start button enabled
	 */
	public void startButtonUnDimmed() {
		start.setEnabled(true);
	}

	public void setGameFrameTitle(int clientID) {
		gameFrame.setTitle("Sjuan Client: " + clientID);
	}

	/**
	 *	this method makes cards clickable 
	 */

	public void addCardAction(ArrayList<Card> cards){
		play.addCardListener(cards);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			controller.newRequest("newGame");
		}
		else if(e.getSource() == end) {
			System.exit(0);
		}
		else if(e.getSource() == pass){
			controller.newRequest("pass");
		}
		else if(e.getSource()==databas){
			controller.newRequest("database");
		}
//		else if(e.getSource() == login) {
//			LoginFrame = new LoginFrame(this);
//		}
		else if(e.getSource() == ready) {
			controller.newRequest("ready");
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
		start.setEnabled(false);
		pass.setEnabled(false);
		databas.setEnabled(false);
		ready.setEnabled(false);
		aboutUs.setEnabled(false);
		play.removeCardListener();
		play.dimAllCards();

	}

	public void unDimAll() {
		start.setEnabled(true);
		end.setEnabled(true);
		pass.setEnabled(true);
		databas.setEnabled(true);
		play.unDimAllCards();
	}
	

}
