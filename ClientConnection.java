package Client1;

import java.io.*;
import java.net.*;

import sjuan.Request;
import sjuan.Response;

public class ClientConnection {
	private ClientController controller;
	private Socket socket;
	private ObjectOutputStream output;
	private ObjectInputStream input;


	public ClientConnection(ClientController controller, String serverIP, int serverPort) throws IOException {
		this.controller = controller;
		socket = new Socket(InetAddress.getByName(serverIP), serverPort);
		output = new ObjectOutputStream(socket.getOutputStream());
		input = new ObjectInputStream(socket.getInputStream());
		Thread thread = new Thread(new ResponseHandler());
		thread.start();
	}

	public void newRequest(Request request) {
		try {
			output.writeObject(request);
			output.flush();
			output.reset();

		}catch(IOException e) {
			e.getStackTrace();
			System.out.println(e);
		}
	}

	public void exit() {
		try {
			socket.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private class ResponseHandler implements Runnable {
		public void run() {
			Response response;
			try {
				while (true) {
					response = (Response)input.readObject();
					controller.newResponse(response);

				}
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
	}
}

