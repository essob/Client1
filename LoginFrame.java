package Client1;

import java.awt.Color;
import java.sql.*;

import sjuan.DataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFrame extends JFrame implements ActionListener{
	private ClientGUI gui;
	private JFrame frame = new JFrame("Logga in");
	private JTextField enterU = new JTextField();
	private JTextField enterP = new JTextField();
	private JLabel user = new JLabel("Ange användarnamn:");
	private JLabel password = new JLabel("Ange lösenord:");
	private JButton button = new JButton("Logga in");
	private JButton newAccount = new JButton("Skapa konto");
	private String res;
	private String res1;
	private String sql;
	
	public LoginFrame (ClientGUI gui) {
		this.gui = gui;
	}
	
	public LoginFrame(){
	frame.setSize(350, 200);
   
	frame.setLocation(500, 200);
	frame.setLayout(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	user.setSize(user.getPreferredSize());
	user.setLocation(10, 10);
	frame.add(user);
	
	enterU.setColumns(15);
	enterU.setSize(enterU.getPreferredSize());
	enterU.setLocation(150, 10);
	frame.add(enterU);
	
	password.setSize(password.getPreferredSize());
	password.setLocation(10, 50);
	frame.add(password);
	
	enterP.setColumns(15);
	enterP.setSize(enterP.getPreferredSize());
	enterP.setLocation(150, 50);
	frame.add(enterP);
	
	button.setSize(button.getPreferredSize());
	button.setLocation(150, 100);
	frame.add(button);
	button.addActionListener(this); 
	
	newAccount.setSize(newAccount.getPreferredSize());
	newAccount.setLocation(150, 130);
	frame.add(newAccount);
	newAccount.addActionListener(this); 
	
	frame.setVisible(true);
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			if(enterU.equals("Anna") && enterP.equals("123")){
				JOptionPane.showMessageDialog(null, "hej");
		}
		
		else if (e.getSource()==newAccount){
			
		}
		
	}
	}
}

