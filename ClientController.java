package Client1;

import java.io.*;

import labd.ClientGUI;
import labd.Commodity;
import labd.Request;
import labd.Response;

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
    }

    public void newRequest(String request) {
        double minPrice, maxPrice;
        try {
            String[] parts = request.split(",");
            System.out.println(parts.length);
            if (parts[0].equals("ALL")) {
                connection.newRequest(new Request(parts[0]));
            } else if (parts[0].equals("PRICE")) {
                minPrice = Double.parseDouble(parts[1]);
                maxPrice = Double.parseDouble(parts[2]);
                connection.newRequest(new Request(parts[0], minPrice, maxPrice));
            } else if (parts[0].equals("EXIT")) {
                exit();
            } else {
                gui.setError("Request: " + request+"\n\nTillåtna förfrågningar:\nALL\nPRICE,nbr,nbr");
            }
        } catch (Exception e) {
            gui.setError("Request: " + request+"\n\nTillåtna förfrågningar:\nALL\nPRICE,nbr,nbr");
        }
    }

    public void exit() {
        connection.exit();
        System.exit(0);
    }
    
    public void newResponse(Response response) {
        Commodity[] commodities = response.getCommodities();
        String message = "Request: " + response.getRequest() + "\n\n";
        for(Commodity commodity : commodities) {
            message += commodity.toString() + "\n";
        }
        gui.setResponse(message);
    }
    
    public static void main(String[] args) {
        new ClientController("127.0.0.1", 7766);
    }
}
