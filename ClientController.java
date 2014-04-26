package Client1;

import java.io.*;

import sjuan.*;

/**
 * this class handles control over a client
 * @author Tobbe
 *
 */
public class ClientController {
	private ClientGUI gui;
	private ClientConnection connection;
	private Card[] cards;
	private int opponent1, opponent2, opponent3;

	/**
	 * constructs a clientcontroller
	 * @param serverIP takes in a server IPNumber
	 * @param serverPort takes in Server Port Number
	 */
	public ClientController(String serverIP, int serverPort) {
		try {
			connection = new ClientConnection(this, serverIP, serverPort);
			gui = new ClientGUI(this);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("connection: " + connection);
	}
	/**
	 * this method creates a request to server
	 */
	public void newRequest() {
		connection.newRequest(new Request("ABC"));
	}

	/**
	 * this method returns Players cards
	 * @return cards returns a players cards
	 */
	public Card[] getPlayerCards() {
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
		this.cards = response.getCards();
		this.opponent1 = response.getOpponentCards1();
		this.opponent2 = response.getOpponentCards2();
		this.opponent3 = response.getOpponentCards3();

		String playercards = "";
		for(Card card : cards) {
			playercards += card.toString() + ", ";
		}
		gui.setPlayersCardsInGUI(cards);
		gui.setNbrOfOpponent1Cards(opponent1);
		gui.setNbrOfOpponent2Cards(opponent2);
		gui.setNbrOfOpponent3Cards(opponent3);
		gui.updateAllPanels();
		gui.startButtonDimmed();
	}

	public void newResponse(Response response) {
		cards = response.getCards();

		//		String message = "";
		//	String message = "Request: " + response.getRequest() + "\n\n";
		//		for(Card card : cards) {
		//			message += card.toString() + "\n";
		//		}
		System.out.println(opponent1);
	}
	public int getOpponent1() {
		return opponent1;
	}

	public int getOpponent2() {
		return opponent2;
	}

	public int getOpponent3() {
		return opponent3;
	}
	public static void main(String[] args) {
		new ClientController("127.0.0.1", 7766);
	}
}
