package Client1;

import java.io.*;

import javax.swing.JOptionPane;

import sjuan.*;

/**
 * this class handles control over a client
 * @author Sjuan
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
	public void newRequest(String str) {
		connection.newRequest(new Request(str));
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
		if (response.getRequest().equals("new")) {
			this.cards = response.getCards();
			this.opponent1 = response.getOpponentCards1();
			this.opponent2 = response.getOpponentCards2();
			this.opponent3 = response.getOpponentCards3();

			gui.setPlayersCardsInGUI(cards);
			gui.setNbrOfOpponent1Cards(opponent1);
			gui.setNbrOfOpponent2Cards(opponent2);
			gui.setNbrOfOpponent3Cards(opponent3);
			gui.updateAllPanels();
			gui.startButtonDimmed();
		}
	}
	/**
	 * this method handle the response from the server
	 * @param response takes in a response from server
	 */
	public void newResponse(Response response) {
		System.out.println(response.getRequest());
		if (response.getRequest().equals("new")) {
			getStartConditions(response);

		}
		else if (response.getRequest().equals("pass")){
			JOptionPane.showMessageDialog(null, "Du kan inte passa just nu!");
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
}
