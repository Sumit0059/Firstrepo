package LibraryManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class createAccount extends JFrame implements ActionListener 
{
	private static final String Joptionpane = null;
	JLabel l1,l2,l3;
	JTextField j1,j2,j3;
	JButton b1,b2;
	
	public createAccount()
	{
		setTitle("Add Books");
		setVisible(true);
		setLayout(null);
		setSize(400,500);

		JPanel ap = new JPanel();
		ap.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Create-Account", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(220, 20, 60)));
		ap.setBounds(70, 40, 270, 300);
		ap.setLayout(null);
		add(ap);
		
		l1 = new JLabel("User Name :");
		l1.setBounds(15,25,100,20);
		l2 = new JLabel("Name :");
		l2.setBounds(15,70,100,20);
		l3 = new JLabel("Password :");
		l3.setBounds(15,110,100,20);
		ap.add(l1);ap.add(l2);ap.add(l3);
		
		j1 = new JTextField();
		j1.setBounds(93,26,150,20);
		j2 = new JTextField();
		j2.setBounds(70,70,150,20);
		j3 = new JPasswordField();
		j3.setBounds(100,110,150,20);
		ap.add(j1);ap.add(j2);ap.add(j3);
		
		b1 = new JButton("Create");
		b1.setBounds(65,180,80,30);
		b2 = new JButton("back");
		b2.setBounds(150,180,70,30);
		b1.addActionListener(this);
	    b2.addActionListener(this);
	    ap.add(b1);ap.add(b2);
	} // constructor close 
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try
		{
			
			if (e.getSource() == b1) 
			{
				conection conn = new conection();
				String str = "insert into account(username, name, password) values(?, ?, ?)";
				PreparedStatement st = conn.con.prepareStatement(str);
				
				st.setString(1, j1.getText());
				st.setString(2, j2.getText());
				st.setNString(3, j3.getText());
				
				int i = st.executeUpdate();
				if(i > 0)
				{
					JOptionPane.showMessageDialog(rootPane, "Student Added Successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
					this.setVisible(false);
					new login().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Please Insert Correct Details.", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			if (e.getSource() == b2)
			{
				this.setVisible(false);
				new login().setVisible(true);
			}
		} //try close 
		catch(Exception e1) {e1.printStackTrace();}
	} // action close

	public static void main(String[] args)
	{
		new createAccount(); 
	}
}
