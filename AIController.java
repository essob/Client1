package Client1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import sjuan.Card;
import sjuan.Player;
import sjuan.Request;
import sjuan.Response;

public class AIController {
	private AIConnection connection;
	private int clientID, gameID, passCounter = 0;
	private ArrayList <Card> cards = new ArrayList <Card>(); 
	private ArrayList <Card> gameBoardCards = new ArrayList <Card>();
	private HashMap <Integer, ArrayList<Card>> AICardsList = new HashMap <Integer, ArrayList<Card>>();
	//	private HashMap <Integer, AIConnection> connectionList = new HashMap <Integer, AIConnection>();
	private String request = "playCard";

	public AIController(String serverIP, int serverPort) {
		try {
			connection = new AIConnection(this, serverIP, serverPort);
			newRequest("clientID");
			//			System.out.println(clientID);
			//			connectionList.put(clientID, connection);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("connection: " + connection);

	}

	public void newRequest(String request) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, false));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}

	}

	public void newRequest(String request, int clientID) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, false));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newRequest(String request, String cardName) {
		try {
			connection.newRequest(new Request(request, cardName, clientID, gameID));
		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newRequest(String request, String cardName, int counter) {
		try {
			//			counter = passCounter;
			connection.newRequest(new Request(request, cardName, clientID, gameID, counter));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newResponse(Response response) {
		if (response.getRequest().equals("newGame")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameID = response.getGameID();
			AICardsList.put(clientID, cards);
			System.out.println("Client: " + clientID);
			for (Card card : AICardsList.get(clientID))
				System.out.print(card + ", ");
			System.out.println("");
			if (response.isHasHeart7()) {
				for (Card card : cards) {
					if (card.toString().equals("h7")) {
						String cardName = card.toString();
						newRequest("playCard", cardName, 0);
						break;
					}
				}
			}
		}
		else if (response.getRequest().equals("clientID")) {
			this.clientID = response.getClientID();
			//			connectionList.put(clientID, connection);
			newRequest("newAIPlayer", clientID);
		}
		//		else if (response.getRequest().equals("newAIPlayer")) {
		//			this.clientID = response.getClientID();
		//			System.out.println("vad är det för id: " + clientID);
		//			newRequest("newAIPlayer");
		//		}
		else if (response.getRequest().equals("createAI")) {
			new AIController("127.0.0.1", 7766);

		}
		else if (response.getRequest().equals("playCard")) {
			this.clientID = response.getClientID();
			this.gameBoardCards = response.getGameBoardCards();
			for (Card card : cards) {
				if (checkIfAICanPlayCard(card)) {
					newRequest("playCard", card.toString(), 0);
					break;
				}
			}
		}

		else if (response.getRequest().equals("updatePlayerWithAI")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameBoardCards = response.getGameBoardCards();
			System.out.println(clientID + ": har spelat: " );
			newRequest("nextPlayer");

		}

		else if (response.getRequest().equals("giveACard")) {
			this.clientID = response.getClientID();
			request = "giveACard";
			passCounter = response.getPassCounter();
			if (passCounter==3) {
				newRequest("recieveCards", clientID);
			}
			else {
			}
		}
		else if (response.getRequest().equals("wakePlayer")) {
			this.clientID = response.getClientID();
			request = "playCard";
			newRequest("getGameConditions", clientID);
			System.out.println(clientID + ": har vaknat");


		}
		else if (response.getRequest().equals("updateAndPlayCard")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameBoardCards = response.getGameBoardCards();
			boolean canPlay = false;
			Card card = null;
			for (Card temp : cards) {
				canPlay = checkIfAICanPlayCard(temp);
				if (canPlay==true) {
					card = temp;
					break;
				}
			}
			if (canPlay==true) {
				newRequest("playCard", card.toString());
				System.out.println(clientID + ": har spelat: " + card.toString());
			}
			else {
				newRequest("pass");
				System.out.println(clientID + ": har spelat: pass" );
			}
		}
		else if (response.getRequest().equals("pass")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			newRequest("giveACard", null, passCounter);
			System.out.println(clientID + ": passar");

		}
		else if (response.getRequest().equals("giveACard")) {
			//			request = "giveACard";
			this.cards = response.getCards();
			this.clientID = response.getClientID();
			this.passCounter = response.getPassCounter();
			if (passCounter==3) {
				newRequest("recieveCards");
				System.out.println(clientID + ": tar emot 3 kort " );
			}
			else {
				newRequest("giveACardToAPlayer", cards.get(0).toString(), passCounter);
				System.out.println(clientID + ": ger kortet: " + cards.toString() + " counter är " + passCounter);

			}
		}
		else if (response.getRequest().equals("updateAndGiveCard")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			newRequest("giveACardToAPlayer", cards.get(0).toString(), passCounter);	
			System.out.println(clientID + ": uppdaterar och vill ge ett kort");

		}
	}
	//	private void setClientID(int clientID) {
	//		this.clientID = clientID;		
	//	}

	public void giveOrPlay (String cardName) {
		if (request.equals("playCard")) {
			newRequest("playCard", cardName, 0);
		}
		else if (request.equals("giveACard")) {
			newRequest("giveACardToAPlayer", cardName, passCounter);
		}
		else {
			JOptionPane.showMessageDialog(null, "Något är fel i giveOrPlay- metoden");
		}
	}
	public boolean checkIfAICanPlayCard(Card card) {

		// if hjärter7
		if (card.getType() == 0) {
			if (card.getValue() == 6) {
				return true;
			} else {
				for (int i = 0; i < gameBoardCards.size(); i++) {
					Card right = gameBoardCards.get(i);
					if (right.getType() == 0 && right.getValue() == (card.getValue() + 1) 
							|| (right.getType() == 0 && right.getValue() == (card.getValue() -1))) {
						return true;
					}
				}
			}
			return false;
		}
		// // if någon annan sjua och hjärter7 utlagd
		else if ((card.getValue() == 6)) {
			for (int i = 0; i < gameBoardCards.size(); i++) {
				Card right = gameBoardCards.get(i);
				if (right.getType() == 0) {
					return true;
				}
			}
		}
		//
		else if (card.getType() == 1) {
			for (int i = 0; i < gameBoardCards.size(); i++) {
				Card right = gameBoardCards.get(i);
				if (right.getType() == 1 && right.getValue() == (card.getValue() + 1) 
						|| (right.getType() == 1 && right.getValue() == (card.getValue() -1))) {
					return true;
				}
			}
		}

		else if (card.getType() == 2) {
			for (int i = 0; i < gameBoardCards.size(); i++) {
				Card right = gameBoardCards.get(i);
				if (right.getType() == 2 && right.getValue() == (card.getValue() + 1) 
						|| (right.getType() == 2 && right.getValue() == (card.getValue() -1))) {
					return true;
				}
			}
		}

		else if (card.getType() == 3) {
			for (int i = 0; i < gameBoardCards.size(); i++) {
				Card right = gameBoardCards.get(i);
				if (right.getType() == 3 && right.getValue() == (card.getValue() + 1) 
						|| (right.getType() == 3 && right.getValue() == (card.getValue() -1))) {
					return true;
				}
			}
		}
		return false;
	}
}
