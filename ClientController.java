package Client1;

import java.io.*;

public class ClientController {
	//    private ClientGUI gui;
	private ClientConnection connection;

	public ClientController(String serverIP, int serverPort) {
		try {
			//            gui = new ClientGUI();
			connection = new ClientConnection(this, serverIP, serverPort);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public void newRequest(String request) {
	}

	public void exit() {
		connection.exit();
		System.exit(0);
	}

	public void newResponse(Response response) {
		String [] cards = response.getCards();
		String message = "Request: " + response.getRequest() + "\n\n";
		for(String card : cards) {
			message += card + "\n";
		}
		//        gui.setResponse(message);
		System.out.println(message);
	}

	public static void main(String[] args) {
		new ClientController("127.0.0.1", 7766);
	}
}
