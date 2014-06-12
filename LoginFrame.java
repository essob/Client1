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

	private JFrame logInFrame = new JFrame("Logga in");
	private JTextField tfuserName = new JTextField();
	private JPasswordField tfPassword = new JPasswordField('*');
	private JLabel lbluser = new JLabel("Ange Användarnamn");
	private JLabel lblpassword = new JLabel("Ange Lösenord");
	private JButton btnLogIn = new JButton("Logga in");
	private JButton btnClose = new JButton("Avsluta");
	private JButton btnNewUser = new JButton("Skapa ny användare");
	private ClientController controller;
	private String userName, passWord;


	public LoginFrame(ClientController controller){
		this.controller = controller;
		logInFrame.setSize(350, 200);
		logInFrame.setLocation(500, 200);
		logInFrame.setLayout(null);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		lbluser.setSize(lbluser.getPreferredSize());
		lbluser.setLocation(10, 10);
		logInFrame.add(lbluser);

		tfuserName.setColumns(15);
		tfuserName.setSize(tfuserName.getPreferredSize());
		tfuserName.setLocation(150, 10);
		logInFrame.add(tfuserName);

		lblpassword.setSize(lblpassword.getPreferredSize());
		lblpassword.setLocation(10, 40);
		logInFrame.add(lblpassword);

		tfPassword.setColumns(15);
		tfPassword.setSize(tfPassword.getPreferredSize());
		tfPassword.setLocation(150, 40);
		logInFrame.add(tfPassword);

		btnLogIn.setSize(btnLogIn.getPreferredSize());
		btnLogIn.setLocation(150, 70);
		logInFrame.add(btnLogIn);
		btnLogIn.addActionListener(this);

		btnClose.setSize(btnClose.getPreferredSize());
		btnClose.setLocation(150, 100);
		logInFrame.add(btnClose);
		btnClose.addActionListener(this);

		btnNewUser.setSize(btnNewUser.getPreferredSize());
		btnNewUser.setLocation(150, 130);
		logInFrame.add(btnNewUser);
		btnNewUser.addActionListener(this);
		btnNewUser.setVisible(true);
		logInFrame.setVisible(true);
	}


	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==btnNewUser)
		{
			new NewUser(controller);
		}

		else if(ae.getSource()==btnClose)
		{
			System.exit(0);
		}
		else if(ae.getSource()==btnLogIn)
		{
			setUserName(tfuserName.getText().toString());
			setPassWord(tfPassword.getText().toString());
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