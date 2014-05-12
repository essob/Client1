package Client1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JPasswordField.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;

public class LoginFrame extends JFrame implements ActionListener{

	public static Connection connection;
	public static Statement statement;
	private JFrame frame = new JFrame("Logga in");
	private JTextField t1 = new JTextField();
	private JPasswordField t2 = new JPasswordField('*');
	private JLabel user = new JLabel("Ange Användarnamn");
	private JLabel password = new JLabel("Ange Lösenord");
	private JButton b3 = new JButton("Logga in");
	private JButton b4 = new JButton("Avsluta");
	private JButton b5 = new JButton("Skapa ny användare");

	public LoginFrame(){
		frame.setSize(350, 200);

		frame.setLocation(500, 200);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		user.setSize(user.getPreferredSize());
		user.setLocation(10, 10);
		frame.add(user);

		t1.setColumns(15);
		t1.setSize(t1.getPreferredSize());
		t1.setLocation(150, 10);
		frame.add(t1);

		password.setSize(password.getPreferredSize());
		password.setLocation(10, 40);
		frame.add(password);

		t2.setColumns(15);
		t2.setSize(t2.getPreferredSize());
		t2.setLocation(150, 40);
		frame.add(t2);

		b3.setSize(b3.getPreferredSize());
		b3.setLocation(150, 70);
		frame.add(b3);
		b3.addActionListener(this);

		b4.setSize(b4.getPreferredSize());
		b4.setLocation(150, 100);
		frame.add(b4);
		b4.addActionListener(this);

		b5.setSize(b5.getPreferredSize());
		b5.setLocation(150, 130);
		frame.add(b5);
		b5.addActionListener(this);

		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b5)
		{
			new NewUser();
		}

		else if(ae.getSource()==b4)
		{
			System.exit(0);
		}
		else if(ae.getSource()==b3)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");	//Hämtar database-drivern
				connection = DriverManager.getConnection ("jdbc:mysql://195.178.232.7:4040/ab4607", "ab4607", "prinsessan");	// Koppla upp mot database-servern
				statement = connection.createStatement();	// Erhåller en Statement-implementering för att exekvera SQL-satser


				// H�r �r anslutningen skapad och du kan jobba mot databasen.  
				// Du anv�nder referensvaraibeln statement n�r du anv�nder databasen. Du kan  
				// dock endast jobba mot ett ResultSet (en fr�ga) i taget.


				String userName =t1.getText().toString();
				String password=t2.getText().toString();
				ResultSet res = statement.executeQuery("SELECT AnvändarNamn FROM statistics where AnvändarNamn='" + userName  + "' and Lösenord='" + password + "'");
				if (res.next()) {
					JOptionPane.showMessageDialog(this,"Du är inloggad:)");    
				} else{
					JOptionPane.showMessageDialog(this,"Fel användarnamn/lösenord");
				}


			}
			catch ( ClassNotFoundException e ) {
				JOptionPane.showMessageDialog(this,e.getMessage());
			}

			//
			catch(SQLException e) {
				JOptionPane.showMessageDialog(this,"Sql Error");
			}

		}
	}


}
