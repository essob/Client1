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
	private JLabel email = new JLabel("Ange E-post");
	private JLabel user = new JLabel("Ange Användarnamn");
	private JLabel password = new JLabel("Ange Lösenord");
	private JButton b3 = new JButton("Registrera dig");
	private String AnvändarNamn, Lösenord, id;




	public NewUser(){
		frame.setSize(500, 300 );
		frame.setLocation(500, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		email.setSize(email.getPreferredSize());
		email.setLocation(10, 10);
		frame.add(email);

		t1.setColumns(15);
		t1.setSize(t1.getPreferredSize());
		t1.setLocation(150, 10);
		frame.add(t1);

		user.setSize(user.getPreferredSize());
		user.setLocation(10, 40);
		frame.add(user);

		t2.setColumns(15);
		t2.setSize(t1.getPreferredSize());
		t2.setLocation(150, 40);
		frame.add(t2);

		password.setSize(password.getPreferredSize());
		password.setLocation(10, 70);
		frame.add(password);

		t3.setColumns(15);
		t3.setSize(t2.getPreferredSize());
		t3.setLocation(150, 70);
		frame.add(t3);

		b3.setSize(b3.getPreferredSize());
		b3.setLocation(150, 100);
		frame.add(b3);
		b3.addActionListener(this);

		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b3){
			try {
				DataBase.connect(t1.getText().toString(), t2.getText().toString(), t3.getText().toString());
				JOptionPane.showMessageDialog(null, "Välkommen till sjuan " + t2.getText().toString() + ":)");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new NewUser();
	}
}
