package Client1;

import java.io.*;
import sjuan.*;
import sjuan.Card;

public class ClientController {
	private ClientGUI gui;
	private ClientConnection connection;

	public ClientController(String serverIP, int serverPort) {
		try {
			gui = new ClientGUI(this);
			connection = new ClientConnection(this, serverIP, serverPort);
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("connection: " + connection);
	}

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
	}

	public static void main(String[] args) {
		new ClientController("127.0.0.1", 7766);
	}
}
