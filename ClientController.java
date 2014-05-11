package Client1;

import java.io.*; 
import java.util.ArrayList;
import javax.swing.JOptionPane;

import javax.swing.JTable;

import sjuan.*;

/**
 * this class handles control over a client
 * @author Sjuan
 *
 */
public class ClientController {
	private ClientGUI gui;
	private JTable table;
	private ClientConnection connection;
	private Object tabell;
	private ArrayList <Card> cards, gameBoardCards;
	private int opponent1, opponent2, opponent3, clientID;


	/**
	 * constructs a client controller
	 * @param serverIP takes in a server IPNumber
	 * @param serverPort takes in Server Port Number
	 */

	public ClientController(String serverIP, int serverPort) {
		try {
			connection = new ClientConnection(this, serverIP, serverPort);
			gui = new ClientGUI(this);

		} catch (IOException e) {
			System.out.println(e);
			e.getStackTrace();
		}
		System.out.println("connection: " + connection);
	}

	/**
	 * this method creates a request to server
	 */
	public void newRequest(String request) {
		try {
			connection.newRequest(new Request(request));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	/**
	 * this method creates a request to server
	 * @param request takes in a request as a string
	 * @param card takes in a card as a string
	 */
	public void newRequest(String request, String cardName) {
		try {
			connection.newRequest(new Request(request, cardName, clientID));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	/**
	 * this method returns Players cards
	 * @return cards returns a players cards
	 */
	public ArrayList<Card> getPlayerCards() {
		return cards;
	}
	/**
	 * this method gets the players cards
	 * @param response takes in the players cards
	 */
	public void setPlayerCards(Response response ) {
		this.cards = response.getCards();
	}

	/**
	 * this method gets the needed start conditions for the for the game
	 * @param response
	 */

	public void getStartConditions(Response response) {
		if (response.getRequest().equals("new")) {
			this.cards = response.getCards();
			this.opponent1 = response.getOpponentCards1();
			this.opponent2 = response.getOpponentCards2();
			this.opponent3 = response.getOpponentCards3();
			this.clientID = response.getClientID();

			gui.setPlayersCardsInGUI(cards);
			gui.setNbrOfOpponent1Cards(opponent1);
			gui.setNbrOfOpponent2Cards(opponent2);
			gui.setNbrOfOpponent3Cards(opponent3);
			gui.updateAllPanels();
			playersTurn();
			gui.startButtonDimmed();
			gui.setGameFrameTitle();

		}
	}

	public void getPlayCardAction(Response response) {
		cards.clear();
		this.cards = response.getCards();
		gameBoardCards = response.getGameBoardCards();
		setCardAtGameBoard(getCard(response.getCardName()));
		gui.setPlayersCardsInGUI(cards);
		gui.addCardAction(cards);
		gui.updateAllPanels();

	}

	/**
	 * this method handle the response from the server
	 * @param response takes in a response from server
	 */
	public void newResponse(Response response) {
		if (response.getRequest().equals("new")) {
			getStartConditions(response);

		}
		else if (response.getRequest().equals("pass")) {
			JOptionPane.showMessageDialog(null, "Du skulle ha passat nu om metoden var färdigskriven");
		}
		else if (response.getRequest().equals("passainte"))
			JOptionPane.showMessageDialog(null, "Du kan inte passa just nu!");

		else if (response.getRequest().equals("playCard")) {
			getPlayCardAction(response);
		}
		else if (response.getRequest().equals("dontPlayCard")) {
			JOptionPane.showMessageDialog(null, "Du kan inte lägga ut detta kortet.");
		}

		else if(response.getRequest().equals("end")){
			JOptionPane.showMessageDialog(null, response.getSql());
		}
	}

	/**
	 * this method returns this opponents cards
	 * @return opponent1 returns this opponents cards
	 */
	public int getOpponent1() {
		return opponent1;
	}

	/**
	 * this method returns this opponents cards
	 * @return opponent2 returns this opponents cards
	 */
	public int getOpponent2() {
		return opponent2;
	}

	/**
	 * this method returns this opponents cards
	 * @return opponent3 returns this opponents cards
	 */
	public int getOpponent3() {
		return opponent3;
	}

	/**
	 * this method returns this clients ID
	 * @return clientID returns a ID of this Client
	 */
	public int getClientID() {
		return clientID;
	}

	/**
	 * this method tells gui to place a card at game board
	 * @param card takes in a card to place at game board
	 */
	public void setCardAtGameBoard(Card card) {
		gui.setCardAtGameBoard(card);
	}

	/**
	 * this method use a string of the cards name to return it as a card
	 * @param cardName takes in a string of a cards name
	 * @return card returns a card
	 */
	public Card getCard (String cardName) {
		int i = 0;
		while (gameBoardCards.iterator().hasNext()) {
			if (gameBoardCards.get(i).toString().equals(cardName))
				return gameBoardCards.get(i);
			i++;
		}
		return null;
	}
	public void playersTurn() {
		for (Card card : cards) {
			if (card.toString().equals("h7")) {
				gui.addCardAction(cards);
				break;
			}
		}
	}
}
