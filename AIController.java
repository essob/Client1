package Client1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import sjuan.Card;
import sjuan.Request;
import sjuan.Response;

public class AIController {
	private AIConnection connection;
	private int clientID, gameID, passCounter;
	private ArrayList <Card> cards;
	private HashMap <Integer, ArrayList<Card>> AICardsList = new HashMap <Integer, ArrayList<Card>>();
	private HashMap <Integer, AIConnection> connectionList = new HashMap <Integer, AIConnection>();
	private String request = "playCard";
	//	private boolean humanPlayer = false;

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
			connection.newRequest(new Request(request, cardName, clientID, gameID, passCounter));

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
					if (card.toString().equals("h7"));
					String cardName = card.toString();
					newRequest("playCard", cardName);
				}
			}
		}
		else if (response.getRequest().equals("clientID")) {
			this.clientID = response.getClientID();
			connectionList.put(clientID, connection);
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
			newRequest("nextPlayer", clientID);
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
			request = "playCard";
		}
	}

	//	private void setClientID(int clientID) {
	//		this.clientID = clientID;		
	//	}

	public void giveOrPlay (String cardName) {
		if (request.equals("playCard")) {
			newRequest("playCard", cardName);
		}
		else if (request.equals("giveACard")) {
			newRequest("giveACardToAPlayer", cardName);
		}
		else {
			JOptionPane.showMessageDialog(null, "Något är fel i giveOrPlay- metoden");
		}
	}
}
