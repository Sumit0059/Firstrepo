package LibraryManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.protocol.Resultset;

public class login extends JFrame implements ActionListener
{
	JLabel l1,l2;
	JTextField j1,j2;
	JButton b1,b2,b3;
	
	public login()
	{
		setSize(800,500);
		setVisible(true);
		setLayout(null);
		setTitle("Login/SignUp");
		
		l1 = new JLabel("User Name :");
		l1.setBounds(50,120,80,20);
		l2 = new JLabel("Password :");
		l2.setBounds(50,170,70,20);
		j1 = new JTextField();
		j1.setBounds(130,120,150,20);
		j1.addActionListener(this);
		j2 = new JTextField();
		j2.setBounds(130,170,150,20);
		j2.addActionListener(this);
		add(l1);add(l2);add(j1);add(j2);
		b1 = new JButton("Login");
		b1.setBounds(80,200,75,35);
		b1.addActionListener(this);
		b2 = new JButton("SignUp");
		b2.setBounds(170,200,80,35);
		b2.addActionListener(this);
		b3 = new JButton("Forgot Password");
		b3.setBounds(85,250,150,35);
		b3.addActionListener(this);
		add(b1);add(b2);add(b3);
		
		JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("logo.jpeg")));
        l.setBounds(300, 65, 400, 300);
        add(l);    
        
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == b1) {
			try {
				conection conn = new conection();
				String sql = "select * from account where username=? and password=?";
				PreparedStatement st = conn.con.prepareStatement(sql);
				
				st.setString(1, j1.getText());
				st.setString(2, j2.getText());
				ResultSet rs = st.executeQuery();
				
				if(rs.next()) {
					this.setVisible(false);
					new main().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Invalid Details!!!...");
				}
			}catch(Exception e1) {
				System.out.println(e1);
			} 
		}
		if (e.getSource() == b2) {
			this.setVisible(false);
			new createAccount().setVisible(true);
		}
		if (e.getSource() == b3) {
			this.setVisible(false);
			new forgot().setVisible(true);
		}
	}

	public static void main(String[] args)
	{
		new login();
	}
}
