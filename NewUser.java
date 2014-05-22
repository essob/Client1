package Client1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.*;

import javax.swing.JPasswordField.*;

import com.mysql.jdbc.PreparedStatement;

public class NewUser extends JFrame implements ActionListener{	
	public static Connection connection;
	public static java.sql.PreparedStatement statement; 

	private JFrame frame = new JFrame("Skapa ny användare");
	private static JTextField t1 = new JTextField();
	private static JTextField t2 = new JTextField();
	private static JPasswordField t3 = new JPasswordField('*');
	private JLabel email = new JLabel("Ange E-post");
	private JLabel user = new JLabel("Ange Användarnamn");
	private JLabel password = new JLabel("Ange Lösenord");
	private JButton b3 = new JButton("Registrera dig");


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




	public static void connect(String id, String AnvändarNamn, String LösenOrd) throws SQLException {
		try {

			Class.forName("com.mysql.jdbc.Driver"); // H�mta database-driver, kastar ClassNotFoundException
			connection = DriverManager.getConnection("jdbc:mysql://195.178.232.7:4040/ab4607","ab4607","prinsessan"); // Koppla upp mot database-servern, kastar SQLException 
			statement = connection.prepareStatement("INSERT INTO statistics(id, AnvändarNamn, LösenOrd) VALUES(?,?,?)"); // Erh�lla en Statement-implementering f�r att exekvera SQL-satser, kastar  // SQLException 
			// H�r �r anslutningen skapad och du kan jobba mot databasen.  
			// Du anv�nder referensvaraibeln statement n�r du anv�nder databasen. Du kan  
			// dock endast jobba mot ett ResultSet (en fr�ga) i taget.
			statement.setString(1, id);
			statement.setString(2, AnvändarNamn);
			statement.setString(3, LösenOrd);
			statement.executeUpdate(); //Efter anropet innehåller statement värdet på antalet berörda rader i databasen.
		} catch(ClassNotFoundException e1) {
			System.out.println("Databas-driver hittades ej: "+e1);
		}
	}

	/**
	 * Avsluta databas-kopplingen, b�da anropen kastar SQLException
	 * @throws SQLException
	 */

	public static void disconnect() throws SQLException {
		statement.close();
		connection.close();
	}


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==b3){
			try {
				connect(t1.getText().toString(), t2.getText().toString(), t3.getText().toString());
				JOptionPane.showMessageDialog(null, "Välkommen till sjuan " + t2.getText() + ":)");
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