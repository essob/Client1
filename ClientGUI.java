package Client1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
/**
 * This class generates a Grafical User Interface to play the game
 */
public class ClientGUI extends JPanel implements ActionListener{
	private JPanel panel = new JPanel();
	private JFrame gameFrame = new JFrame("Sjuan");
	private JPanel bottenPanel = new JPanel();
	private JPanel playerPanel = new JPanel();
	private JPanel opponent1Panel = new JPanel();
	private JPanel opponent2Panel = new JPanel();
	private JPanel opponent3Panel = new JPanel();
	private JPanel optionsPanel = new JPanel();
	private JLabel pl1Card = new JLabel();
	private JLabel plbCard = new JLabel();
	private JLabel plbCard2 = new JLabel();
	private JLabel plbCard3 = new JLabel();
	private JLabel plbCard4 = new JLabel();
	private JLabel plbCard5 = new JLabel();
	private JLabel plbCard6 = new JLabel();
	private JLabel plbCard7 = new JLabel();
	private JLabel plbCard8 = new JLabel();
	private JLabel plbCard9 = new JLabel();
	private JLabel plbCard10 = new JLabel();
	private JLabel plbCard11 = new JLabel();
	private JLabel plbCard12 = new JLabel();
	private JLabel plbCard13 = new JLabel();
	private JButton b1 = new JButton();

	private JLabel plb2Card = new JLabel();
	private JLabel plb2Card2 = new JLabel();
	private JLabel plb2Card3 = new JLabel();
	private JLabel plb2Card4 = new JLabel();
	private JLabel plb2Card5 = new JLabel();
	private JLabel plb2Card6 = new JLabel();
	private JLabel plb2Card7 = new JLabel();
	private JLabel plb2Card8 = new JLabel();
	private JLabel plb2Card9 = new JLabel();
	private JLabel plb2Card10 = new JLabel();
	private JLabel plb2Card11 = new JLabel();
	private JLabel plb2Card12 = new JLabel();
	private JLabel plb2Card13 = new JLabel();

	private JLabel plb3Card = new JLabel();
	private JLabel plb3Card2 = new JLabel();
	private JLabel plb3Card3 = new JLabel();
	private JLabel plb3Card4 = new JLabel();
	private JLabel plb3Card5 = new JLabel();
	private JLabel plb3Card6 = new JLabel();
	private JLabel plb3Card7 = new JLabel();
	private JLabel plb3Card8 = new JLabel();
	private JLabel plb3Card9 = new JLabel();
	private JLabel plb3Card10 = new JLabel();
	private JLabel plb3Card11 = new JLabel();
	private JLabel plb3Card12 = new JLabel();
	private JLabel plb3Card13 = new JLabel();

	
	
	private JButton pass = new JButton("Pass");
	private JButton end = new JButton("Avsluta spel");
	private StartButton start 	= new StartButton("Börja spelomgång");
	private ClientController controller;
	/**
	 * Constructs the Gui
	 */
	public ClientGUI(ClientController controller) {
		this.controller = controller;
		GamePanel();
	}
	/**
	 * This Method creates the Gui Frame
	 */
	public void GamePanel(){
		gameFrame.setBounds(40, 200, 1000, 600);
		gameFrame.setResizable(false);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setLayout(new BorderLayout());
		gameFrame.add(panel(), BorderLayout.CENTER);
		gameFrame.add(bottenPanel, BorderLayout.SOUTH);
		gameFrame.add(opponent1Panel(), BorderLayout.WEST);
		gameFrame.add(opponent2Panel(), BorderLayout.NORTH);
		gameFrame.add(opponent3Panel(), BorderLayout.EAST);


		bottenPanel.setBackground(Color.BLACK);
		bottenPanel.add(playerPanel(), BorderLayout.WEST);
		bottenPanel.add(optionsPanel(), BorderLayout.EAST);
		
		start.addActionListener(this);
		gameFrame.setVisible(true);
	}
	/**
	 * This method returns a panel
	 * @return panel returns a panel
	 */
	public JPanel panel() {
		panel.setPreferredSize(new Dimension(400, 100));
		panel.setFont(new Font("Arial", Font.BOLD, 24));
		panel.setBackground(Color.GREEN.darker().darker());
		return panel;
	}
	/**
	 * This method returns a panel to represent the actual player panel
	 * @return player1Panel return the actual player panel
	 */

	public JPanel playerPanel() {
		playerPanel.setPreferredSize(new Dimension(830, 100));
		playerPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		playerPanel.setBackground(Color.BLACK);
		pl1Card.setIcon(readFiles());
		playerPanel.add(pl1Card);
		return playerPanel;
	}
	
	public JPanel optionsPanel() {
		optionsPanel.setPreferredSize(new Dimension(150, 100));
		optionsPanel.setBackground(Color.BLACK);
		optionsPanel.add(start);
		optionsPanel.add(end);
		optionsPanel.add(pass);
		return optionsPanel;

	}
	/**
	 * This method returns a panel to represent the opponent1
	 * @return opponent1Panel return a panel of opponent1
	 */
	public JPanel opponent1Panel() {
		opponent1Panel.setPreferredSize(new Dimension(100, 200));
		opponent1Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent1Panel.setBackground(Color.BLUE.darker());
		plbCard.setIcon(readBack());
		opponent1Panel.add(plbCard);
		plbCard2.setIcon(readBack2());
		opponent1Panel.add(plbCard2);
		plbCard3.setIcon(readBack2());
		opponent1Panel.add(plbCard3);
		plbCard4.setIcon(readBack2());
		opponent1Panel.add(plbCard4);
		plbCard5.setIcon(readBack2());
		opponent1Panel.add(plbCard5);
		plbCard6.setIcon(readBack2());
		opponent1Panel.add(plbCard6);
		plbCard7.setIcon(readBack2());
		opponent1Panel.add(plbCard7);
		plbCard8.setIcon(readBack2());
		opponent1Panel.add(plbCard8);
		plbCard9.setIcon(readBack2());
		opponent1Panel.add(plbCard9);
		plbCard10.setIcon(readBack2());
		opponent1Panel.add(plbCard10);
		plbCard11.setIcon(readBack2());
		opponent1Panel.add(plbCard11);
		plbCard12.setIcon(readBack2());
		opponent1Panel.add(plbCard12);
		plbCard13.setIcon(readBack2());
		opponent1Panel.add(plbCard13);

		return opponent1Panel;
	}
	/**
	 * This method returns a panel to represent the opponent2
	 * @return opponent1Panel return a panel of opponent2
	 */
	public JPanel opponent2Panel() {
		opponent2Panel.setPreferredSize(new Dimension(200, 100));
		opponent2Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent2Panel.setBackground(Color.MAGENTA.darker().darker());
		plb2Card.setIcon(readBack3());
		opponent2Panel.add(plb2Card);
		plb2Card2.setIcon(readBack4());
		opponent2Panel.add(plb2Card2);
		plb2Card3.setIcon(readBack4());
		opponent2Panel.add(plb2Card3);
		plb2Card4.setIcon(readBack4());
		opponent2Panel.add(plb2Card4);
		plb2Card5.setIcon(readBack4());
		opponent2Panel.add(plb2Card5);
		plb2Card6.setIcon(readBack4());
		opponent2Panel.add(plb2Card6);
		plb2Card7.setIcon(readBack4());
		opponent2Panel.add(plb2Card7);
		plb2Card8.setIcon(readBack4());
		opponent2Panel.add(plb2Card8);
		plb2Card9.setIcon(readBack4());
		opponent2Panel.add(plb2Card9);
		plb2Card10.setIcon(readBack4());
		opponent2Panel.add(plb2Card10);
		plb2Card11.setIcon(readBack4());
		opponent2Panel.add(plb2Card11);
		plb2Card12.setIcon(readBack4());
		opponent2Panel.add(plb2Card12);
		plb2Card13.setIcon(readBack4());
		opponent2Panel.add(plb2Card13);
		return opponent2Panel;
	}
	/**
	 * This method returns a panel to represent the opponent3
	 * @return opponent1Panel return a panel of opponent3
	 */
	public JPanel opponent3Panel() {
		opponent3Panel.setPreferredSize(new Dimension(100, 200));
		opponent3Panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		opponent3Panel.setBackground(Color.ORANGE);
		plb3Card2.setIcon(readBack5());
		opponent3Panel.add(plb3Card2);
		plb3Card3.setIcon(readBack5());
		opponent3Panel.add(plb3Card3);
		plb3Card4.setIcon(readBack5());
		opponent3Panel.add(plb3Card4);
		plb3Card5.setIcon(readBack5());
		opponent3Panel.add(plb3Card5);
		plb3Card6.setIcon(readBack5());
		opponent3Panel.add(plb3Card6);
		plb3Card7.setIcon(readBack5());
		opponent3Panel.add(plb3Card7);
		plb3Card8.setIcon(readBack5());
		opponent3Panel.add(plb3Card8);
		plb3Card9.setIcon(readBack5());
		opponent3Panel.add(plb3Card9);
		plb3Card10.setIcon(readBack5());
		opponent3Panel.add(plb3Card10);
		plb3Card11.setIcon(readBack5());
		opponent3Panel.add(plb3Card11);
		plb3Card12.setIcon(readBack5());
		opponent3Panel.add(plb3Card12);
		plb3Card13.setIcon(readBack5());
		opponent3Panel.add(plb3Card13);
		plb3Card.setIcon(readBack());
		opponent3Panel.add(plb3Card);
		return opponent3Panel;
	}
	/**
	 * This metod reads a picture file and return it as a Icon Object
	 * @return icon returns a Icon Object
	 */
	public ImageIcon readFiles(String str) {
		ImageIcon icon = new ImageIcon("src/sjuan/files/cards_png/" + str +".png");
		return icon;
	}

	public ImageIcon readBack() {
		ImageIcon iconBack = new ImageIcon("src/sjuan/files/cards_png/b1fh.png");
		return iconBack;
	}

	public ImageIcon readBack2() {
		ImageIcon iconBack = new ImageIcon("src/sjuan/files/cards_png/b1pb.png");
		return iconBack;
	}

	public ImageIcon readBack3() {
		ImageIcon iconBack = new ImageIcon("src/sjuan/files/cards_png/b1fv.png");
		return iconBack;
	}

	public ImageIcon readBack4() {
		ImageIcon iconBack = new ImageIcon("src/sjuan/files/cards_png/b1pr.png");
		return iconBack;
	}

	public ImageIcon readBack5() {
		ImageIcon iconBack = new ImageIcon("src/sjuan/files/cards_png/b1pt.png");
		return iconBack;
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			controller.newRequest();
		}
		
		if(e.getSource() == end) {

		}
		if(e.getSource() == pass){

		}
	}

	/**
	 * Main method to test Gui-class
	 * @param args
	 */
	public static void main(String[] args) {
		ClientGUI gui = new ClientGUI(null);
	}
}
