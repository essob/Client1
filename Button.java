package Client1;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
	private ImageIcon icon;

	public Button(String str) {
		super(str);
		icon = new ImageIcon("src/sjuan/files/cards_png/" + str + ".png");
	}
//	protected void paintComponent(Graphics g) {
//		super.paintComponent(g);
//	int x = 40;
//	int y = 60;
//		g.drawImage(icon.getImage(), x, y, null);
//	}

}
