package Client1;

import java.io.*; 
import sjuan.*;
import sjuan.Card;
import java.util.ArrayList;


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
	private int opponent, opponent2, opponent3;

	/**
	 * constructs a clientcontroller
	 * @param serverIP takes in a server IPNumber
	 * @param serverPort takes in Server Port Number
	 */

	public ClientController(String serverIP, int serverPort) {
		try {
			gui = new ClientGUI(this);
			connection = new ClientConnection(this, serverIP, serverPort);
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


	public void exit() {
		connection.exit();
		System.exit(0);
	}

	public void newResponse(Response response) {
		Card [] cards = response.getCards();
		String message = "Request: " + response.getRequest() + "\n\n";
		for(Card card : cards) {
			message += card.toString() + "\n";
		}
		//        gui.setResponse(message);
		System.out.println(message);

	/**
	 * this method gets the players cards
	 * @param response takes in the players cards
	 */
	public void getPlayerCards(Response response ) {
		this.cards = response.getCards();
	}
	/**
	 * this method gets the needed start conditions for the for the game
	 * @param response
	 */
	public void getStartConditions(Response response) {
		this.cards = response.getCards();
		this.opponent = response.getOpponentCards1();
		this.opponent2 = response.getOpponentCards2();
		this.opponent3 = response.getOpponentCards3();

		String playercards = "";
		for(Card card : cards) {
			playercards += card.toString() + ", ";
		}

		System.out.println(playercards + "\n" + opponent + " " +opponent2 + " " +opponent3);

	}

	public void newResponse(Response response) {
		cards = response.getCards();

		//		String message = "";
		//	String message = "Request: " + response.getRequest() + "\n\n";
		//		for(Card card : cards) {
		//			message += card.toString() + "\n";
		//		}
		System.out.println(opponent);

	}

	public static void main(String[] args) {
		new ClientController("127.0.0.1", 7766);
	}
}
