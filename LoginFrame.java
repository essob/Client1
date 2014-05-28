package Client1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JPasswordField.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;


public class LoginFrame extends JFrame implements ActionListener{

	public static Connection connection;
	public static Statement statement;
	private JFrame logInFrame = new JFrame("Logga in");
	private JTextField t1 = new JTextField();
	private JPasswordField t2 = new JPasswordField('*');
	private JLabel user = new JLabel("Ange Användarnamn");
	private JLabel password = new JLabel("Ange Lösenord");
	private JButton logInButton = new JButton("Logga in");
	private JButton b4 = new JButton("Avsluta");
	private JButton newUserButton = new JButton("Skapa ny användare");
	private ClientController controller;
	private String userName, passWord;

	/**
	 *  constructs a loginframe so the user can log in
	 *  @param controller takes in this loginframes controller 
	 */
	public LoginFrame(ClientController controller){
		this.controller = controller;
		logInFrame.setSize(350, 200);
		logInFrame.setLocation(500, 200);
		logInFrame.setLayout(null);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		user.setSize(user.getPreferredSize());
		user.setLocation(10, 10);
		logInFrame.add(user);

		t1.setColumns(15);
		t1.setSize(t1.getPreferredSize());
		t1.setLocation(150, 10);
		logInFrame.add(t1);

		password.setSize(password.getPreferredSize());
		password.setLocation(10, 40);
		logInFrame.add(password);

		t2.setColumns(15);
		t2.setSize(t2.getPreferredSize());
		t2.setLocation(150, 40);
		logInFrame.add(t2);

		logInButton.setSize(logInButton.getPreferredSize());
		logInButton.setLocation(150, 70);
		logInFrame.add(logInButton);
		logInButton.addActionListener(this);

		b4.setSize(b4.getPreferredSize());
		b4.setLocation(150, 100);
		logInFrame.add(b4);
		b4.addActionListener(this);

		newUserButton.setSize(newUserButton.getPreferredSize());
		newUserButton.setLocation(150, 130);
		logInFrame.add(newUserButton);
		newUserButton.addActionListener(this);
		newUserButton.setVisible(true);
		logInFrame.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==newUserButton)
		{
			new NewUser();
		}

		else if(ae.getSource()==b4)
		{
			System.exit(0);
		}
		else if(ae.getSource()==logInButton)
		{
			setUserName(t1.getText().toString());
			setPassWord(t2.getText().toString());
			logInDb();
		}
	}

	
	public void logInDb(){
		controller.newRequest("Login", getUserName(), getPassWord());
	}

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void close() {
		logInFrame.dispose();
	}

}


