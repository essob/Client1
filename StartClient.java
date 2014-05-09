package Client1;
/**
 * This class starts a Client
 * @author Sjuan
 *
 */
public class StartClient {
	public static void main(String[] args) {
		new ClientController("10.2.0.93", 7766);
	}
}
