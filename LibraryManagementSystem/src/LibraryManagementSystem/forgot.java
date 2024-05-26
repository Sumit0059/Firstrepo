package LibraryManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class forgot extends JFrame implements ActionListener {

	JLabel l1,l2,l3;
	JButton b1,b2;
	JTextField j1,j2;

	forgot()
	{
		setVisible(true);
		setSize(600,400);
		setLayout(null);

		l3 = new JLabel("Know Your Password Here");
		l3.setBounds(160,20,170,30);
		l3.setForeground(Color.orange);

		l1 = new JLabel("User Name :");
		l1.setBounds(100,100,150,30);
		l2 = new JLabel("Your Password is :");
		l2.setBounds(100,140,150,30);

		j1 = new JTextField();
		j1.setBounds(240,100,150,30);
		j2 = new JTextField();
		j2.setBounds(230,140,150,30);

		b1 = new JButton("Search");
		b1.setBounds(140,180,90,35);
		b1.addActionListener(this);
		b2 = new JButton("back");
		b2.setBounds(250,180,90,35);
		b2.addActionListener(this);

		add(l1);add(l2);add(b1);add(j1);add(j2);add(l3);add(b2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try
		{
			if (e.getSource() == b1)
			{
				conection conn = new conection();
				String str = "select password from account where username=?";
				PreparedStatement st = conn.con.prepareStatement(str);

				st.setString(1, j1.getText());
				ResultSet rs = st.executeQuery();
				if(rs.next()) 
				{
					 
					j2.setText(rs.getString("password"));
					JOptionPane.showMessageDialog(rootPane, "Your Password is Found.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null,  "UserName Doesnot Exist", "warning", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		catch(Exception e1) {
			e1.printStackTrace();
		}
		if (e.getSource()==b2) {
			this.setVisible(false);
			new login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new forgot();
	}

}
