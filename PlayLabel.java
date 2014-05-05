package Client1;

import javax.swing.*;

import sjuan.Card;

public class PlayLabel extends JLabel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel hearts7 = new JLabel();
	private JLabel spades7 = new JLabel();
	private JLabel diamonds7 = new JLabel();
	private JLabel clubs7 = new JLabel();

	private JLabel heartsBigger = new JLabel();
	private JLabel heartsSmaller = new JLabel();

	private JLabel spadesBigger = new JLabel();
	private JLabel spadesSmaller = new JLabel();

	private JLabel diamondsBigger = new JLabel();
	private JLabel diamondsSmaller = new JLabel();

	private JLabel clubsBigger = new JLabel();
	private JLabel clubsSmaller = new JLabel();
	private ClientGUI gui;


	public PlayLabel(ClientGUI gui) {
		this.gui = gui;
	}


	public JLabel getHeart7() {
		hearts7.setIcon(gui.readFiles("h7s"));
		hearts7.setLocation(130, 150);
		hearts7.setSize(96, 71);
		return hearts7;
	}

	public JLabel getSpade7() {
		spades7.setIcon(gui.readFiles("s7s"));
		spades7.setLocation(280, 150);
		spades7.setSize(96, 71);
		return spades7;
	}

	public JLabel getDiamond7() {
		diamonds7.setIcon(gui.readFiles("d7s"));
		diamonds7.setLocation(430, 150);
		diamonds7.setSize(96, 71);
		return diamonds7;
	}

	public JLabel getClub7() {
		clubs7.setIcon(gui.readFiles("c7s"));
		clubs7.setLocation(580, 150);
		clubs7.setSize(96, 71);
		return clubs7;
	}

	public JLabel getHeartB() {
		heartsBigger.setIcon(gui.readFiles("h8"));
		heartsBigger.setLocation(145, 235);
		heartsBigger.setSize(71, 96);
		return heartsBigger;
	}

	public JLabel getHeartS() {
		heartsSmaller.setIcon(gui.readFiles("h6"));
		heartsSmaller.setLocation(145, 40);
		heartsSmaller.setSize(71, 96);
		return heartsSmaller;
	}

	public JLabel getSpadeB() {
		spadesBigger.setIcon(gui.readFiles("s8"));
		spadesBigger.setLocation(295, 235);
		spadesBigger.setSize(71, 96);
		return spadesBigger;
	}

	public JLabel getSpadeS(Card card) {
		spadesSmaller.setIcon(gui.readFiles(card.toString()));
		spadesSmaller.setLocation(295, 40);
		spadesSmaller.setSize(71, 96);
		return spadesSmaller;
	}

	public JLabel getDiamondB() {
		diamondsBigger.setIcon(gui.readFiles("d8"));
		diamondsBigger.setLocation(445, 235);
		diamondsBigger.setSize(71, 96);
		return diamondsBigger;
	}

	public JLabel getDiamondS() {
		diamondsSmaller.setIcon(gui.readFiles("d6"));
		diamondsSmaller.setLocation(445, 40);
		diamondsSmaller.setSize(71, 96);
		return diamondsSmaller;
	}

	public JLabel getClubB() {
		clubsBigger.setIcon(gui.readFiles("c8"));
		clubsBigger.setLocation(595, 235);
		clubsBigger.setSize(71, 96);
		return clubsBigger;
	}

	public JLabel getClubS() {
		clubsSmaller.setIcon(gui.readFiles("c6"));
		clubsSmaller.setLocation(595, 40);
		clubsSmaller.setSize(71, 96);
		return clubsSmaller;
	}
}
