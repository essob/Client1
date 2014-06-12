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
	private ClientConnection connection;
	private ArrayList <Card> cards, gameBoardCards;
	private int opponent1, opponent2, opponent3, clientID, gameID = 0, passCounter = 0;
	private String request;
	private LoginFrame loginFrame;

	/**
	 * constructs a client controller
	 * @param serverIP takes in a server IPNumber
	 * @param serverPort takes in Server Port Number
	 */

	public ClientController(String serverIP, int serverPort) {
		try {
			connection = new ClientConnection(this, serverIP, serverPort);
			newRequest("clientID");
			loginFrame  = new LoginFrame(this);		


		} catch (IOException e) {
			System.out.println(e);
			e.getStackTrace();
		}
//		System.out.println("connection: " + connection);
	}

	/**
	 * this method creates a request to server
	 */
	public void newRequest(String request) {
		try {
			connection.newRequest(new Request(request, clientID, gameID, true, 0));

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
	public void newRequest(String request, String cardName, int counter) {
		try {
			counter = passCounter;
			connection.newRequest(new Request(request, cardName, clientID, gameID, passCounter));

		} catch (Exception e) {
			System.out.println("Request: " + request+" är felfelfel");
			e.getStackTrace();
		}
	}

	public void newRequest(String request, String userName, String passWord) {
		try {
			connection.newRequest(new Request(request, userName, passWord));

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
		request = "playCard";
		this.cards = response.getCards();
		this.opponent1 = response.getOpponentCards1();
		this.opponent2 = response.getOpponentCards2();
		this.opponent3 = response.getOpponentCards3();
		this.gameID = response.getGameID();
		gui.setPlayersCardsInGUI(cards);
		gui.setNbrOfOpponent1Cards(opponent1);
		gui.setNbrOfOpponent2Cards(opponent2);
		gui.setNbrOfOpponent3Cards(opponent3);
		gui.unDimAll();
		if (response.isHasHeart7()==false)
			gui.dimAll();
		gui.updateAllPanels();
		gui.addCardAction(cards);
	}

	/**
	 * this method gets the needed start conditions for the for the game
	 * @param response
	 */
	public void getStartConditions(Response response) {
		if (response.getClientID()== clientID) {
			setStartConditions(response);
		}
	}

	/**
	 * this method handle the response from the server
	 * @param response takes in a response from server
	 */
	public void newResponse(Response response) {
		if (response.getRequest().equals("newGame")) {
			if (response.getCards()!=null) {
				getStartConditions(response);
			}
			else {
				gameID = response.getGameID();
				newRequest("newGame");
			}
		}
		else if (response.getRequest().equals("newGame2")) {
			if (response.getCards()!=null) {
				getStartConditions(response);
			}
			else {
				gameID = response.getGameID();
				newRequest("newGame2");
			}
		}
		else if (response.getRequest().equals("newGame3")) {
			if (response.getCards()!=null) {
				getStartConditions(response);
			}
			else {
				gameID = response.getGameID();
				newRequest("newGame3");
			}
		}
		else if (response.getRequest().equals("newGame4")) {
			if (response.getCards()!=null) {
				getStartConditions(response);
			}
			else {
				gameID = response.getGameID();
				newRequest("newGame4");
			}
		}
		else if (response.getRequest().equals("createAI")) {
			new AIController("127.0.0.1", 7766, response.getNbrOfAI());

		}


		else if (response.getRequest().equals("clientID")) {
			this.clientID = response.getClientID();
		}

		else if (response.getRequest().equals("clientsMissing")) {
			JOptionPane.showMessageDialog(null, "Fler klienter bör ansluta sig");
		}

		else if (response.getRequest().equals("pass")) {
			gui.dimAll();
			passCounter = 1;
			newRequest("giveACard", null, passCounter);
			//			System.out.println(clientID + ": har spelat: pass" );
			gui.setInstructions("De andra spelarna kommer nu skicka dig var sitt kort");

		}

		else if (response.getRequest().equals("passainte")) {
			JOptionPane.showMessageDialog(null, "Du kan inte passa just nu!");
		}
		else if (response.getRequest().equals("dontPlayCard")) {
			JOptionPane.showMessageDialog(null, "Du kan inte lägga ut detta kortet.");
		}
		else if(response.getRequest().equals("end")){
			JOptionPane.showMessageDialog(null, response.getSql());
		}
		else if(response.getRequest().equals("Login")){
			if(response.getLogOk()== true){
				loginFrame.close();
				gui = new ClientGUI(this, response.getUserName());
				gui.dimAllExceptStart();
				JOptionPane.showMessageDialog(null, "du är inloggad");
			}
			else{
				JOptionPane.showMessageDialog(null, "Fel användarnamn/ lösenord");
			}
		}

		else if (response.getRequest().equals("wakePlayer")) {
			gui.unDimAll();
			passCounter = response.getPassCounter();
			if (passCounter <= 3 && passCounter > 0) {
				newRequest("getAllGameConditions");
				gui.updateAllPanels();
				//				System.out.println(response.getClientID() + " har vaknat och ska ge bort ett kort");
				request = "giveACard";

				if(passCounter == 2) {
					gui.setInstructions("Skicka ett kort till spelaren rakt över");
				}
				else if (passCounter == 3){
					gui.setInstructions("Skicka ett kort till spelaren till vänster");
				}
			}
			else if (passCounter==4) {
				request = "playCard";
				passCounter = 0;
				//				System.out.println(response.getClientID() + " har vaknat och ska ta mot tre kort");
				newRequest("recieveCards", null, passCounter);
				newRequest("getAllGameConditions");
				gui.updateAllPanels();
				gui.dimAll();
			}
			else if (passCounter == 0){
				newRequest("getAllGameConditions");
				gui.updateAllPanels();
				//				System.out.println(clientID + ": har vaknat" );
			}
		}
		else if ( response.getRequest().equals("update")){
			setCardsAtGameBoard(response.getGameBoardCards());
			gui.setNbrOfOpponent1Cards(response.getOpponentCards1());
			gui.setNbrOfOpponent2Cards(response.getOpponentCards2());
			gui.setNbrOfOpponent3Cards(response.getOpponentCards3());
			gui.updateAllPanels();
			gui.addCardAction(this.cards);
			if (response.getIfPlayerWin()!=null) {
				JOptionPane.showMessageDialog(null, response.getIfPlayerWin());
				gui.dimAll();
			}

		}
		else if ( response.getRequest().equals("updatePlayerWithAI")){
			setCardsAtGameBoard(response.getGameBoardCards());
			gui.setPlayersCardsInGUI(response.getCards());
			gui.setNbrOfOpponent1Cards(response.getOpponentCards1());
			gui.setNbrOfOpponent2Cards(response.getOpponentCards2());
			gui.setNbrOfOpponent3Cards(response.getOpponentCards3());
			gui.updateAllPanels();
			gui.dimAll();
			if (response.getIfPlayerWin()==null)
				newRequest("nextPlayer");
			gui.updateAllPanels();
			gui.addCardAction(this.cards);
			if (response.getIfPlayerWin()!=null) {
				JOptionPane.showMessageDialog(null, response.getIfPlayerWin());
			}
		}

		else if ( response.getRequest().equals("updateAll")){
			gui.setPlayersCardsInGUI(response.getCards());
			setCardsAtGameBoard(response.getGameBoardCards());
			gui.setNbrOfOpponent1Cards(response.getOpponentCards1());
			gui.setNbrOfOpponent2Cards(response.getOpponentCards2());
			gui.setNbrOfOpponent3Cards(response.getOpponentCards3());
			gui.updateAllPanels();
			gui.addCardAction(response.getCards());
			if (response.getIfPlayerWin()!=null) {
				JOptionPane.showMessageDialog(null, response.getIfPlayerWin());
			}

		}

		else if ( response.getRequest().equals("recieveCardsUpdate")){
			passCounter = 0;
			gui.setPlayersCardsInGUI(response.getCards());
			setCardsAtGameBoard(response.getGameBoardCards());
			gui.setNbrOfOpponent1Cards(response.getOpponentCards1());
			gui.setNbrOfOpponent2Cards(response.getOpponentCards2());
			gui.setNbrOfOpponent3Cards(response.getOpponentCards3());
			gui.updateAllPanels();
			gui.addCardAction(response.getCards());
			gui.dimAll();
			if (response.getIfPlayerWin()!=null) {
				JOptionPane.showMessageDialog(null, response.getIfPlayerWin());
			}

		}

		else if ( response.getRequest().equals("updateAndGiveCard")){
			request = "giveACard";
			passCounter = response.getPassCounter();
			gui.setPlayersCardsInGUI(response.getCards());
			setCardsAtGameBoard(response.getGameBoardCards());
			gui.setNbrOfOpponent1Cards(response.getOpponentCards1());
			gui.setNbrOfOpponent2Cards(response.getOpponentCards2());
			gui.setNbrOfOpponent3Cards(response.getOpponentCards3());
			gui.updateAllPanels();
			gui.addCardAction(response.getCards());
			gui.unDimAll();
			if(passCounter == 1) {
				gui.setInstructions("Skicka ett kort till spelaren till höger");
			}
			if (response.getIfPlayerWin()!=null) {
				JOptionPane.showMessageDialog(null, response.getIfPlayerWin());
			}


		}
		else if ( response.getRequest().equals("database")){
			JOptionPane.showMessageDialog( null, "Förluster: " + response.getSql());

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

	public void giveOrPlay (String cardName) {
		if (request.equals("playCard")) {
			newRequest("playCard", cardName, 0);
		}
		else if (request.equals("giveACard")) {
			request="playCard";
			passCounter++;
			newRequest("giveACardToAPlayer", cardName, passCounter);
//			System.out.println(clientID + ": har gett bort: " + cardName);
			newRequest("getAllGameConditions");
			gui.updateAllPanels();
			gui.dimAll();
		}
		else {
			JOptionPane.showMessageDialog(null, "Något är fel i giveOrPlay- metoden");
		}
	}
}
