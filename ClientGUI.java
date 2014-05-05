
package Client1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import sjuan.Card;
/**
 * This class generates a Grafical User Interface to play the game
 */
public class ClientGUI extends JPanel implements ActionListener{
	private JPanel panel = new JPanel();
	private JFrame gameFrame = new JFrame("Sjuan");
	private JPanel PlayersPanel = new JPanel();
	private JPanel playerPanel = new JPanel();
	private JPanel opponent1Panel = new JPanel();
	private JPanel opponent2Panel = new JPanel();
	private JPanel opponent3Panel = new JPanel();
	private JPanel optionsPanel = new JPanel();

	private JButton pass = new JButton("Pass");
	private JButton end = new JButton("Avsluta spel");
	private StartButton start = new StartButton("Börja spelomgång");
	private ClientController controller;
	private PlayLabel pLabel = new PlayLabel(this);
	private PlayersPanel play = new PlayersPanel(this);

	/**
	 * Constructs the Gui
	 */
	public ClientGUI(ClientController controller) {
		this.controller = controller;
		GamePanel();
	}

	/**
	 * This Method creates the Gui Frame
	 */
	public void GamePanel(){
		gameFrame.setBounds(40, 200, 1000, 600);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(panel(), BorderLayout.CENTER);
		gameFrame.add(playerPanel(), BorderLayout.SOUTH);
		gameFrame.add(opponent1Panel(), BorderLayout.WEST);
		gameFrame.add(PlayersPanel, BorderLayout.NORTH);
		gameFrame.add(opponent3Panel(), BorderLayout.EAST);

		PlayersPanel.setBackground(Color.MAGENTA.darker().darker());
		PlayersPanel.add(opponent2Panel(), BorderLayout.WEST);
		PlayersPanel.add(optionsPanel(), BorderLayout.EAST);

		start.addActionListener(this);
		end.addActionListener(this);
		pass.addActionListener(this);
		gameFrame.setVisible(true);

	}

	/**
	 * This method returns a panel
	 * @return panel returns a panel
	 */
	public JPanel panel() {
		//		panel.setPreferredSize(new Dimension(400, 100));
		panel.setLayout(null);
		panel.setFont(new Font("Arial", Font.BOLD, 24));
		panel.setBackground(Color.GREEN.darker().darker());

		//		panel.add(pLabel.getHeart7());
		//		panel.add(pLabel.getSpade7());
		//		panel.add(pLabel.getDiamond7());
		//		panel.add(pLabel.getClub7());
		//		
		//		panel.add(pLabel.getHeartB());
		//		panel.add(pLabel.getHeartS());
		//		
		//		panel.add(pLabel.getSpadeB());
		//		panel.add(pLabel.getSpadeS());
		//		
		//		panel.add(pLabel.getDiamondB());
		//		panel.add(pLabel.getDiamondS());
		//		
		//		panel.add(pLabel.getClubB());
		//		panel.add(pLabel.getClubS());


		return panel;	
	}
	
	public void setCardAtGameBoard(Card card) {
		panel.add(pLabel.getSpadeS(card));
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
	}

	public JPanel optionsPanel() {
		optionsPanel.setPreferredSize(new Dimension(150, 100));
		optionsPanel.setBackground(Color.MAGENTA.darker().darker());
		optionsPanel.add(start);
		optionsPanel.add(end);
		optionsPanel.add(pass);

		return optionsPanel;
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
		JLabel opponent1Cards;
		if (nbr != 0)
			for (int i = 0; i < nbr; i++) {
				opponent1Cards = new JLabel();
				if (i==0)
					opponent1Cards.setIcon(readFiles("b1fh"));
				else
					opponent1Cards.setIcon(readFiles("b1pb"));
				opponent1Panel.add(opponent1Cards);
			}
	}

	/**
	 * This method returns a panel to represent the opponent2
	 * @return opponent1Panel return a panel of opponent2
	 */
	public JPanel opponent2Panel() {
		opponent2Panel.setPreferredSize(new Dimension(830, 100));
		opponent2Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent2Panel.setBackground(Color.MAGENTA.darker().darker());

		return opponent2Panel;
	}

	/**
	 * this method sets amount of cards in opponent2s panel
	 * @param nbr takes in the amount of cards in opponent2s hand
	 */
	public void setNbrOfOpponent2Cards (int nbr) {
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
		panel.updateUI();
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
	/**
	 * this method gives buttons make some action when pressed
	 */

	public void setGameFrameTitle() {
		gameFrame.setTitle("Sjuan Client: " + controller.getClientID());
	}

	/**
	 *	this method makes cards clickable 
	 */
	public void addCardAction(){
		play.addCardListener();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			controller.newRequest("new");
		}
		else if(e.getSource() == end) {
			System.exit(0);
		}
		else if(e.getSource() == pass){
			controller.newRequest("pass");
		}
	}
	
	/**
	 * this method play a card from a hand to the gameboard
	 * @param cardName takes in a string of a cards name
	 */
	public void playCard(String cardName) {
		Card card = controller.getCard(cardName);
		controller.newRequest("playCard", card);
		updateAllPanels();
	}
}

