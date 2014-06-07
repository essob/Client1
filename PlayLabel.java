package Client1;

import javax.swing.*;

import sjuan.Card;

/**
 * Class for put the card on right places on gameBoard 
 * 
 * @author Emily Elmseld 21 maj 2014
 *
 */
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


	public JLabel getHeart7(Card card) {
		hearts7.setIcon(gui.readFiles(card.toString()+"s"));
		hearts7.setLocation(130, 150);
		hearts7.setSize(96, 71);
		return hearts7;
	}

	public JLabel getSpade7(Card card) {
		spades7.setIcon(gui.readFiles(card.toString()+"s"));
		spades7.setLocation(280, 150);
		spades7.setSize(96, 71);
		return spades7;
	}

	public JLabel getDiamond7(Card card) {
		diamonds7.setIcon(gui.readFiles(card.toString()+"s"));
		diamonds7.setLocation(430, 150);
		diamonds7.setSize(96, 71);
		return diamonds7;
	}

	public JLabel getClub7(Card card) {
		clubs7.setIcon(gui.readFiles(card.toString()+"s"));
		clubs7.setLocation(580, 150);
		clubs7.setSize(96, 71);
		return clubs7;
	}

	public JLabel getHeartB(Card card) {
		heartsBigger.setIcon(gui.readFiles(card.toString()));
		heartsBigger.setLocation(145, 235);
		heartsBigger.setSize(71, 96);
		return heartsBigger;
	}

	public JLabel getHeartS(Card card) {
		heartsSmaller.setIcon(gui.readFiles(card.toString()));
		heartsSmaller.setLocation(145, 40);
		heartsSmaller.setSize(71, 96);
		return heartsSmaller;
	}

	public JLabel getSpadeB(Card card) {
		spadesBigger.setIcon(gui.readFiles(card.toString()));
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

	public JLabel getDiamondB(Card card) {
		diamondsBigger.setIcon(gui.readFiles(card.toString()));
		diamondsBigger.setLocation(445, 235);
		diamondsBigger.setSize(71, 96);
		return diamondsBigger;
	}

	public JLabel getDiamondS(Card card) {
		diamondsSmaller.setIcon(gui.readFiles(card.toString()));
		diamondsSmaller.setLocation(445, 40);
		diamondsSmaller.setSize(71, 96);
		return diamondsSmaller;
	}

	public JLabel getClubB(Card card) {
		clubsBigger.setIcon(gui.readFiles(card.toString()));
		clubsBigger.setLocation(595, 235);
		clubsBigger.setSize(71, 96);
		return clubsBigger;
	}

	public JLabel getClubS(Card card) {
		clubsSmaller.setIcon(gui.readFiles(card.toString()));
		clubsSmaller.setLocation(595, 40);
		clubsSmaller.setSize(71, 96);
		return clubsSmaller;
	}

	/**
	 * this method takes in a card to find where to place it on game board in gui
	 * @param card takes in a card to place
	 * @return JLabel returns a label set by methods depending on what card
	 */
	public JLabel findOutWhere(Card card) {
		if (card.getType()==0) {
			if (card.getValue()==6)
				return getHeart7(card);
			else if (card.getValue()>6)
				return getHeartB(card);
			else if (card.getValue()<6)
				return getHeartS(card);
		}
		if (card.getType()==1) {
			if (card.getValue()==6)
				return getSpade7(card);
			else if (card.getValue()>6)
				return getSpadeB(card);
			else if (card.getValue()<6)
				return getSpadeS(card);
		}
		if (card.getType()==2) {
			if (card.getValue()==6)
				return getDiamond7(card);
			else if (card.getValue()>6)
				return getDiamondB(card);
			else if (card.getValue()<6)
				return getDiamondS(card);
		}
		if (card.getType()==3) {
			if (card.getValue()==6)
				return getClub7(card);
			else if (card.getValue()>6)
				return getClubB(card);
			else if (card.getValue()<6)
				return getClubS(card);
		}
		return null;
	}
}
