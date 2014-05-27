package Client1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AboutUs extends JPanel implements ActionListener {
	

	public static Statement statement;
	private JFrame aboutUs = new JFrame("Logga in");
	private JTextField t1 = new JTextField();
	private JPasswordField t2 = new JPasswordField('*');
	private JLabel user = new JLabel("Ange Användarnamn");
	private JLabel password = new JLabel("Ange Lösenord");
	private JButton logInButton = new JButton("Logga in");
	private JButton b4 = new JButton("Avsluta");
	private JButton newUserButton = new JButton("Skapa ny användare");
	private String userName, passWord;


	public AboutUs(){
		aboutUs.setSize(350, 200);
		aboutUs.setLocation(500, 200);
		aboutUs.setLayout(null);
		aboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		user.setSize(user.getPreferredSize());
		user.setLocation(10, 10);
		aboutUs.add(user);

		t1.setColumns(15);
		t1.setSize(t1.getPreferredSize());
		t1.setLocation(150, 10);
		aboutUs.add(t1);

		password.setSize(password.getPreferredSize());
		password.setLocation(10, 40);
		aboutUs.add(password);

		t2.setColumns(15);
		t2.setSize(t2.getPreferredSize());
		t2.setLocation(150, 40);
		aboutUs.add(t2);

		logInButton.setSize(logInButton.getPreferredSize());
		logInButton.setLocation(150, 70);
		aboutUs.add(logInButton);
		logInButton.addActionListener(this);

		b4.setSize(b4.getPreferredSize());
		b4.setLocation(150, 100);
		aboutUs.add(b4);
		b4.addActionListener(this);

		newUserButton.setSize(newUserButton.getPreferredSize());
		newUserButton.setLocation(150, 130);
		aboutUs.add(newUserButton);
		newUserButton.addActionListener(this);
		newUserButton.setVisible(true);
		aboutUs.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
//	private JFrame aboutUsFrame = new JFrame("Logga in");
//	private JTextArea textArea = new JTextArea(
//		    "This is an editable JTextArea. " +
//		    "A text area is a \"plain\" text component, " +
//		    "which means that although it can display text " +
//		    "in any font, all of the text is in the same font."
//		);
//	
//	public AboutUs(){
//	aboutUsFrame.setSize(350, 200);
//	aboutUsFrame.setLocation(500, 200);
//	aboutUsFrame.setLayout(null);
//	aboutUsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	
//	textArea.setFont(new Font("Serif", Font.ITALIC, 16));
//	textArea.setLineWrap(true);
//	textArea.setWrapStyleWord(true);
//	
//	aboutUsFrame.setVisible(true);
//	textArea.setVisible(true);
//	}
//}
