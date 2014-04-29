package Client1;
/**
 * This class starts a Client
 * @author Sjuan
 *
 */
public class StartClient {
	public static void main(String[] args) {
		new ClientController("127.0.0.1", 7766);
	}
}
