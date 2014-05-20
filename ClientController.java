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
	private int opponent1, opponent2, opponent3, clientID, gameID = 0;

	/**
	 * constructs a client controller
	 * @param serverIP takes in a server IPNumber
	 * @param serverPort takes in Server Port Number
	 */

	public ClientController(String serverIP, int serverPort) {
		try {
			connection = new ClientConnection(this, serverIP, serverPort);
			newRequest("clientID");
			gui = new ClientGUI(this, clientID);

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
			connection.newRequest(new Request(request, clientID, gameID));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}


	public void newRequest(String request, int clientID) {
		try {
			connection.newRequest(new Request(request, clientID, gameID));

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
			connection.newRequest(new Request(request, cardName, clientID, gameID));

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

	public void setStartConditions(Response response) {
		this.cards = response.getCards();
		this.opponent1 = response.getOpponentCards1();
		this.opponent2 = response.getOpponentCards2();
		this.opponent3 = response.getOpponentCards3();
		this.clientID = response.getClientID();
		this.gameID = response.getGameID();
		gui.setPlayersCardsInGUI(cards);
		gui.setNbrOfOpponent1Cards(opponent1);
		gui.setNbrOfOpponent2Cards(opponent2);
		gui.setNbrOfOpponent3Cards(opponent3);
		gui.addCardAction(cards);
		gui.startButtonDimmed();
		if (response.isHasHeart7()==false)
			gui.dimAll();
		gui.updateAllPanels();

	}

	/**
	 * this method gets the needed start conditions for the for the game
	 * @param response
	 */

	public void getStartConditions(Response response) {
		if (response.getClientID()==clientID) {
			setStartConditions(response);
		}
	}


	public void getPlayCardAction(Response response) {
		cards.clear();
		this.cards = response.getCards();
		gameBoardCards = response.getGameBoardCards();
		setCardsAtGameBoard(gameBoardCards);
		gui.setPlayersCardsInGUI(cards);
		gui.addCardAction(cards);
		gui.updateAllPanels();
		gui.dimAll();
		newRequest("nextPlayer");
	}

	/**
	 * this method handle the response from the server
	 * @param response takes in a response from server
	 */
	public void newResponse(Response response) {
		if (response.getRequest().equals("newGame")) {
			if (response.getCards()!=null)
				getStartConditions(response);

		}
		//		else if (response.getRequest().equals("ready")) {
		//			gui.dimAll();
		//			this.gameID = response.getGameID();
		//			newRequest("newGame");
		//		}
		else if (response.getRequest().equals("clientID")) {
			setClientID(response.getClientID());
		}

		else if (response.getRequest().equals("clientsMissing")) {
			JOptionPane.showMessageDialog(null, "Fler klienter bör ansluta sig");
		}

		else if (response.getRequest().equals("pass")) {
//			newRequest("recieveCards");
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
		else if (response.getRequest().equals("wakePlayer")) {
			gui.unDimAll();
			newRequest("getGameConditions");
		}
		else if ( response.getRequest().equals("updateGUI")){
			setCardsAtGameBoard(response.getGameBoardCards());
			gui.setNbrOfOpponent1Cards(response.getOpponentCards1());
			gui.setNbrOfOpponent2Cards(response.getOpponentCards2());
			gui.setNbrOfOpponent3Cards(response.getOpponentCards3());
			gui.addCardAction(this.cards);
			gui.updateAllPanels();

		}
	}

	private void setClientID(int clientID) {
		this.clientID = clientID;		
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
	 * this method sets cards at gameBoard
	 * @param gameBoardCards takes in a ArrayList<Card>
	 */
	public void setCardsAtGameBoard(ArrayList<Card> gameBoardCards){
		for (Card card : gameBoardCards) {
			gui.setCardAtGameBoard(card);
		}
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

	/**
	 * this method dims all if it is'nt a players turn
	 * @param clientID takes in a Integer of a clientID
	 */
	public void notPlayersTurn (int clientID) {
		if (clientID!=1) {
			gui.dimAll();
		}
		else if (clientID!=2) {
			gui.dimAll();
		}
		else if (clientID!=3) {
			gui.dimAll();
		}
		else if (clientID!=4) {
			gui.dimAll();
		}
	}
}

