package Client1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.JPasswordField.*;

import com.mysql.jdbc.PreparedStatement;

public class NewUser extends JFrame implements ActionListener{	

	private JFrame frame = new JFrame("Skapa ny användare");
	private static JTextField tfUserName = new JTextField();
	private static JPasswordField tfPassword = new JPasswordField('*');
	private JLabel lblNewUser = new JLabel("Ange Användarnamn");
	private JLabel lblNewPassword = new JLabel("Ange Lösenord");
	private JButton btnRegister = new JButton("Registrera dig");
	private ClientController controller;

	public NewUser(ClientController controller){
		this.controller = controller;
		frame.setSize(400, 150 );
		frame.setLocation(500, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		lblNewUser.setSize(lblNewUser.getPreferredSize());
		lblNewUser.setLocation(10, 10);
		frame.add(lblNewUser);

		tfUserName.setColumns(15);
		tfUserName.setBounds(10, 40, 150, 25);
		tfUserName.setLocation(150, 10);
		frame.add(tfUserName);

		lblNewPassword.setSize(lblNewPassword.getPreferredSize());
		lblNewPassword.setLocation(10, 40);
		frame.add(lblNewPassword);

		tfPassword.setColumns(15);
		tfPassword.setBounds(10, 40, 150, 25);
		tfPassword.setLocation(150, 40);
		frame.add(tfPassword);

		btnRegister.setSize(btnRegister.getPreferredSize());
		btnRegister.setLocation(150, 70);
		frame.add(btnRegister);
		btnRegister.addActionListener(this);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnRegister){
			controller.newRequest("createUser", tfUserName.getText(), tfPassword.getText().toString());
		}
	}
}
