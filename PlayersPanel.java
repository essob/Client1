package Client1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import sjuan.Card;

/**
 * this class contains the panel of a players cards in gui
 * @author Tobbe
 *
 */
public class PlayersPanel extends JPanel implements MouseListener{
	private ClientGUI gui;
	private JPanel panel = new JPanel();

	private JLabel playCard1 = new JLabel();
	private JLabel playCard2 = new JLabel();
	private JLabel playCard3 = new JLabel(); 
	private JLabel playCard4 = new JLabel(); 
	private JLabel playCard5 = new JLabel();
	private JLabel playCard6 = new JLabel();
	private JLabel playCard7 = new JLabel(); 
	private JLabel playCard8 = new JLabel();
	private JLabel playCard9 = new JLabel();
	private JLabel playCard10 = new JLabel();
	private JLabel playCard11 = new JLabel();
	private JLabel playCard12 = new JLabel(); 
	private JLabel playCard13 = new JLabel(); 
	private JLabel playCard14 = new JLabel(); 
	private JLabel playCard15 = new JLabel(); 
	private JLabel playCard16 = new JLabel(); 
	private JLabel playCard17 = new JLabel(); 
	private JLabel playCard18 = new JLabel(); 
	private JLabel playCard19 = new JLabel(); 
	private JLabel playCard20 = new JLabel(); 

	private JLabel[] list = {playCard1, playCard2, playCard3 , playCard4, playCard5 , playCard6,
			playCard7 , playCard8, playCard9 , playCard10, playCard11 , playCard12,playCard13 , 
			playCard14, playCard15 , playCard16, playCard17 , playCard18, playCard19 , playCard20};

	/**
	 * constructs a players panel to show what cards a player have and 
	 * to be able to play them by clickng on them
	 * @param gui takes in this players gui
	 */
	public PlayersPanel (ClientGUI gui) {
		this.gui = gui;
		panel.setPreferredSize(new Dimension(830, 100));
		panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		panel.setBackground(Color.BLACK);

	}

	/**
	 * this method sets the players cards in gui
	 * @param cards takes in the players cards
	 */
	public void setPlayersCardsInGUI(Card[] cards) {
		if (cards!=null) {
			for (int i = 0; i < cards.length; i++) {
				Card card = cards[i];
				list[i].setIcon(gui.readFiles(card.toString()));
				list[i].setName(card.toString());
				panel.add(list[i]);
			}
		}
	}
	public void addCardListener() {
		if (list!=null)
			for (int i = 0; i < list.length; i++) {
				list[i].addMouseListener(this);
			}
	}
	// metod som just nu inte används
	public String labelName () {
		return "playCard";
	}
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	//här ska skrivas anrop till gui som i sin tur ska anropa controllern om vad som ska hända
	public void mousePressed(MouseEvent e) {
		JOptionPane.showMessageDialog(null, e.getComponent().getName());

	}
	@Override
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {

	}
}
