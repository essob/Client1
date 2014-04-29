package Client1;

import java.awt.Graphics;

import javax.swing.*;

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



	public void setHeart7() {
	hearts7.setIcon(readFiles("h7s"));
	add(hearts7);
	hearts7.setLocation(130, 150);
	hearts7.setSize(96, 71);
	}
	
	spades7.setIcon(readFiles("s7s"));
	add(spades7);
	spades7.setLocation(280, 150);
	spades7.setSize(96, 71);
	
	diamonds7.setIcon(readFiles("d7s"));
	add(diamonds7);
	diamonds7.setLocation(430, 150);
	diamonds7.setSize(96, 71);
	
	clubs7.setIcon(readFiles("c7s"));
	panel.add(clubs7);
	clubs7.setLocation(580, 150);
	clubs7.setSize(96, 71);
	
	heartsBigger.setIcon(readFiles("h8"));
	panel.add(heartsBigger);
	heartsBigger.setLocation(145, 235);
	heartsBigger.setSize(71, 96);

	heartsSmaller.setIcon(readFiles("h6"));
	panel.add(heartsSmaller);
	heartsSmaller.setLocation(145, 40);
	heartsSmaller.setSize(71, 96);
	
	spadesBigger.setIcon(readFiles("s8"));
	panel.add(spadesBigger);
	spadesBigger.setLocation(295, 235);
	spadesBigger.setSize(71, 96);

	spadesSmaller.setIcon(readFiles("s6"));
	panel.add(spadesSmaller);
	spadesSmaller.setLocation(295, 40);
	spadesSmaller.setSize(71, 96);
	
	diamondsBigger.setIcon(readFiles("d8"));
	panel.add(diamondsBigger);
	diamondsBigger.setLocation(445, 235);
	diamondsBigger.setSize(71, 96);

	diamondsSmaller.setIcon(readFiles("d6"));
	panel.add(diamondsSmaller);
	diamondsSmaller.setLocation(445, 40);
	diamondsSmaller.setSize(71, 96);
	

	clubsBigger.setIcon(readFiles("c8"));
	panel.add(clubsBigger);
	clubsBigger.setLocation(595, 235);
	clubsBigger.setSize(71, 96);

	clubsSmaller.setIcon(readFiles("c6"));
	panel.add(clubsSmaller);
	clubsSmaller.setLocation(595, 40);
	clubsSmaller.setSize(71, 96);
	


	
	}

}
