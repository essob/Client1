package Client1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JPasswordField.*;

import sjuan.DataBase;

import com.mysql.jdbc.PreparedStatement;

public class NewUser extends JFrame implements ActionListener{	
	public static Connection connection;
	public static java.sql.PreparedStatement statement1; 

	private JFrame frame = new JFrame("Skapa ny användare");
	private static JTextField t1 = new JTextField();
	private static JTextField t2 = new JTextField();
	private static JPasswordField t3 = new JPasswordField('*');
	private JLabel newEmail = new JLabel("Ange E-post");
	private JLabel newUser = new JLabel("Ange Användarnamn");
	private JLabel newPassword = new JLabel("Ange Lösenord");
	private JButton b3 = new JButton("Registrera dig");
	private String id, userName, password;
	

	public NewUser(){

		frame.setSize(400, 150 );
		frame.setLocation(500, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		newUser.setSize(newUser.getPreferredSize());
		newUser.setLocation(10, 10);
		frame.add(newUser);

		t2.setColumns(15);
		t2.setBounds(10, 40, 150, 25);
		t2.setLocation(150, 10);
		frame.add(t2);

		newPassword.setSize(newPassword.getPreferredSize());
		newPassword.setLocation(10, 40);
		frame.add(newPassword);

		t3.setColumns(15);
		t3.setBounds(10, 40, 150, 25);
		t3.setLocation(150, 40);
		frame.add(t3);

		b3.setSize(b3.getPreferredSize());
		b3.setLocation(150, 70);
		frame.add(b3);
		b3.addActionListener(this);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b3){
			try {
				DataBase.connect(t2.getText().toString(), t3.getText().toString());
				JOptionPane.showMessageDialog(null, "Välkommen till sjuan " + t2.getText() + ":)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//knappen (request till servern)
		}

	}


}
