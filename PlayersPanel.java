package Client1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import sjuan.Card;

/**
 * this class contains the panel of a players cards in gui
 * @author Tobbe
 *
 */
public class PlayersPanel extends JLabel implements MouseListener{
	private ClientGUI gui;
	private JPanel panel = new JPanel();
	//	private ArrayList <JLabel> list = new ArrayList<JLabel>();

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

	private JLabel [] list = {playCard1, playCard2, playCard3 , playCard4, playCard5 , playCard6,
			playCard7 , playCard8, playCard9 , playCard10, playCard11 , playCard12, playCard13, 
			playCard14, playCard15 , playCard16, playCard17 , playCard18, playCard19 , playCard20 };
	/**
	 * constructs a players panel to show what cards a player have and 
	 * to be able to play them by clickng on them
	 * @param gui takes in this players gui
	 */
	public PlayersPanel (ClientGUI gui) {
		this.gui = gui;
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(830, 100));
		panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10)); 
		panel.setBackground(Color.BLACK);
	}

	/**
	 * this method sets the players cards in gui and place them 
	 * @param cards takes in the players cards
	 */
	public void setPlayersCardsInGUI(ArrayList<Card> cards) {
		clearList();
		//		createList(cards);
		int x = 20;
		int y = 0;
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			list[i].setIcon(gui.readFiles(card.toString()));
			list[i].setName(card.toString());
			list[i].setBounds(x, y,71, 96);
			panel.add(list[i]);
			setCardsEnabled(cards);
			//			list[i].setVisible(false);
			if (cards.size() <=13)
				x+=72;
			else if (cards.size() > 13 )
				x+=65;
			else if (cards.size() > 16)
				x+=60;
			else if (cards.size() > 19)
				x+=55;
			else if (cards.size() > 22)
				x+=50;
			else
				x+=45;
		}
		//		addCardListener(cards);

	}

	public void clearList() {
		for (int i = 0; i < list.length; i++) {
			list[i].setIcon(null);
		}
	}
	//
	//	/**
	//	 * this method add listener for all (card)labels in the list
	//	 */
	//	public void addCardListener(ArrayList <Card>cards) {
	//		if (cards!=null)
	//			for (int i = 0; i < cards.size(); i++) {
	//				list[i].addMouseListener(this);
	//			}
	//	}
	public void setCardsEnabled(ArrayList <Card>cards) {
		if (cards!=null)
			for (int i = 0; i < cards.size(); i++) {
				if (cards.size()<=list.length) {
					list[i].setEnabled(true);
					list[i].setVisible(true);
					list[i].addMouseListener(this);
				}
				else {
					list[i].setEnabled(false);
					list[i].setVisible(false);

				}
			}
	}
	/**
	 * this method returns this panel
	 * @return panel returns this panel
	 */
	public JPanel getPanel() {
		return this.panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	//här ska skrivas anrop till gui som i sin tur ska anropa controllern om vad som ska hända
	public void mousePressed(MouseEvent e) {
		gui.playCard(e.getComponent().getName());

		//		JOptionPane.showMessageDialog(null, e.getComponent().getName());

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
