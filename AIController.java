package Client1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import sjuan.Card;
import sjuan.Request;
import sjuan.Response;

public class AIController {
	private AIConnection connection;
	private int clientID, gameID, opponent1, opponent2, opponent3;
	private ArrayList <Card> cards;
//	private HashMap <Integer, ArrayList<Card>> AIList = new HashMap <Integer, ArrayList<Card>>();
	private boolean humanPlayer = false;


	public AIController(String serverIP, int serverPort) {
		try {
			connection = new AIConnection(this, serverIP, serverPort);
			newRequest("newAIPlayer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void newRequest(String request) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, humanPlayer));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newResponse(Response response) {
		if (response.getRequest().equals("newGame")) {
			this.cards = response.getCards();
			this.gameID = response.getGameID();
		}
		else if (response.getRequest().equals("newAIPlayer")) {
			this.clientID = response.getClientID();
			newRequest("newAIPlayer");
		}
		else if (response.getRequest().equals("clientID")) {
			setClientID(response.getClientID());
		}
		else if (response.getRequest().equals("createAI")) {
			new AIController("127.0.0.1", 7766);

		}
	}

	private void setClientID(int clientID) {
		this.clientID = clientID;		
	}
}
