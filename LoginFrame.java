package Client1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JPasswordField.*;

public class LoginFrame extends JFrame implements ActionListener{
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
        password.setLocation(10, 50);
        frame.add(password);
      
        t2.setColumns(15);
        t2.setSize(t2.getPreferredSize());
        t2.setLocation(150, 50);
        frame.add(t2);
      
        b3.setSize(b3.getPreferredSize());
        b3.setLocation(150, 100);
        frame.add(b3);
        b3.addActionListener(this);
      
        b4.setSize(b4.getPreferredSize());
        b4.setLocation(150, 130);
        frame.add(b4);
        b4.addActionListener(this);
        
        b5.setSize(b5.getPreferredSize());
        b5.setLocation(150, 90);
        b5.addActionListener(this);
      
        frame.setVisible(true);
        }
   
   
   

    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b5)
    	{
    		
    	}

        if(ae.getSource()==b4)
        {
            System.exit(0);
        }
        if(ae.getSource()==b3)
        {
            try {
                Connection conn;
                String dbuser = "root";
                String dbpassw = "";
                String databasename = "statistics";
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection ("jdbc:mysql://195.178.232.7:4040/ab4607", "ab4607", "prinsessan");
                Statement st = conn.createStatement();
                String AnvändarNamn=t1.getText().toString();
                String Lösenord=t2.getText().toString();
                ResultSet res = st.executeQuery("SELECT AnvändarNamn FROM statistics where AnvändarNamn='" + AnvändarNamn + "' and Lösenord='" + Lösenord + "'");
                if (res.next()) {
                    JOptionPane.showMessageDialog(this,"Login Sucessfull.");
                } else{
                    JOptionPane.showMessageDialog(this,"Invalid User Name/Passw");
                }

                if((t1.getText().equals(user))&&(t2.getText().equals(password)))
                {

                }
                else
                {

                }
            }
            catch ( ClassNotFoundException e ) {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(this,"Sql Error");
            }

        }
    }

   
}
