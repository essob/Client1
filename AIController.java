package Client1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import sjuan.Card;
import sjuan.Request;
import sjuan.Response;

public class AIController {
	private AIConnection connection;
	private int clientID, gameID, passCounter = 0, nbrOfAI;
	private ArrayList <Card> cards = new ArrayList <Card>(); 
	private ArrayList <Card> gameBoardCards = new ArrayList <Card>();

	public AIController(String serverIP, int serverPort, int nbrOfAI) {
		try {
			connection = new AIConnection(this, serverIP, serverPort);
			newRequest("clientID", clientID, nbrOfAI);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		System.out.println("connection: " + connection);

	}

	public void newRequest(String request) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, false, nbrOfAI));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}

	}

	public void newRequest(String request, int clientID) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, false, nbrOfAI));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newRequest(String request, int clientID, int nbrOfAI) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, false, nbrOfAI));

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

	public void newRequest(String request, String nbrOfAI, int clientID, int gameID) {
		try {
			connection.newRequest(new Request(request, nbrOfAI, clientID, gameID));
		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newRequest(String request, String cardName, int counter) {
		try {
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
			//			System.out.println("Client: " + clientID);
			//			System.out.println("");
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
		else if (response.getRequest().equals("newGame2")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameID = response.getGameID();
			//			System.out.println("Client: " + clientID);
			//			System.out.println("");
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
		else if (response.getRequest().equals("newGame3")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameID = response.getGameID();
			//			System.out.println("Client: " + clientID);
			//			System.out.println("");
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
			this.nbrOfAI = response.getNbrOfAI();
			if (nbrOfAI==3)
				newRequest("newAIPlayer", clientID);
			else if (nbrOfAI==2)
				newRequest("twoPlayerGame", clientID);
			else if (nbrOfAI==1)
				newRequest("threePlayerGame", clientID);

		}

		else if (response.getRequest().equals("createAI")) {
			new AIController("127.0.0.1", 7766, response.getNbrOfAI());


		}

		else if (response.getRequest().equals("playCard")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
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
			//			System.out.println(clientID + ": har spelat: " );
			if (response.getIfPlayerWin()==null)
				newRequest("nextPlayer");

		}

		else if (response.getRequest().equals("UpdateAndgiveACard")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.passCounter = response.getPassCounter();
			passCounter++;
			newRequest("giveACardToAPlayer", cards.get(0).toString(), passCounter);


		}
		else if (response.getRequest().equals("wakePlayer")) {
			this.clientID = response.getClientID();
			this.passCounter = response.getPassCounter();

			if (passCounter==4) {
				passCounter = 0;
				//				System.out.println(clientID + ": har vaknat och tar emot kort");
				newRequest("recieveCards", null, passCounter);
			}
			else if (passCounter < 4 && passCounter > 0){
				this.cards = response.getCards();
				passCounter++;
				//				System.out.println(clientID + ": har vaknat och ger bort ett kort");
				newRequest("giveACardToAPlayer", cards.get(0).toString(), passCounter);
			}

			else if (passCounter == 0){
				//				System.out.println(clientID + ": har vaknat");
				if (response.getIfPlayerWin()==null)
					newRequest("getGameConditions", clientID);
			}
		}

		else if (response.getRequest().equals("updateAndPlayCard")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameBoardCards = response.getGameBoardCards();
			this.passCounter = response.getPassCounter();
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
				//				System.out.println(clientID + ": har spelat: " + card.toString());
			}
			else {
				newRequest("pass", null , passCounter);
				//				System.out.println(clientID + ": har spelat: pass" );
			}
		}

		else if (response.getRequest().equals("pass")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			passCounter = 1;
			newRequest("giveACard", null, passCounter);
			//			System.out.println(clientID + ": passar");
		}

		else if (response.getRequest().equals("updateAndGiveCard")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.passCounter = response.getPassCounter();
			passCounter++;
			newRequest("giveACardToAPlayer", cards.get(0).toString(), passCounter);	
			//			System.out.println(clientID + ": uppdaterar och vill ge ett kort: " + cards.get(0).toString() + " passcount = " + passCounter);
		}

		else if (response.getRequest().equals("recieveCardsUpdate")) {
			this.clientID = response.getClientID();
			this.cards = response.getCards();
			this.gameBoardCards = response.getGameBoardCards();
			passCounter = 0;
			//			System.out.println(clientID + ": har spelat: " );
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
