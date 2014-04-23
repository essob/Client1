package Client1;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartButton extends JButton {
	private ImageIcon icon;
	
	public StartButton(String str) {
		super(str);
		icon = new ImageIcon("src/sjuan/files/cards_png/b1pt.png");
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x1 = (int)(Math.random()*100 + 30);
		int x2 = (int)(Math.random()*100 + 30);
		int y1 = (int)(Math.random()*100 + 30);
		int y2 = (int)(Math.random()*100 + 30);
		g.drawImage(icon.getImage(), x1, y1, null);
		g.drawImage(icon.getImage(), x2, y2, null);
	}
}
