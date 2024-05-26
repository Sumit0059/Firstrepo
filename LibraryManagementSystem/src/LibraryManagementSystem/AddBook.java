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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddBook extends JFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField j1,j2,j3,j4,j5,j6;
	JButton b1,b2;

	public AddBook()
	{
		setTitle("Add Books");
		setVisible(true);
		setLayout(null);
		setSize(500,600);

		JPanel ap = new JPanel();
		ap.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Add Books Details", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		ap.setBounds(80, 40, 300, 500);
		ap.setLayout(null);
		add(ap);

		l1 = new JLabel("Book_id :");
		l1.setBounds(15,25,100,20);
		l2 = new JLabel("Book_Name :");
		l2.setBounds(15,70,100,20);
		l3 = new JLabel("Book_Publisher :");
		l3.setBounds(15,110,100,20);
		l4 = new JLabel("Book_Price :");
		l4.setBounds(15,148,100,20);
		l5 = new JLabel("Book_Pages :");
		l5.setBounds(15,184,100,20);
		l6 = new JLabel("Date Of Issue :");
		l6.setBounds(15,220,100,20);
		ap.add(l1);ap.add(l2);ap.add(l3);ap.add(l4);ap.add(l5);ap.add(l6);

		j1 = new JTextField();
		j1.setBounds(90,26,150,20);
		j2 = new JTextField();
		j2.setBounds(105,70,150,20);
		j3 = new JTextField();
		j3.setBounds(120,110,150,20);
		j4 = new JTextField();
		j4.setBounds(110,148,150,20);
		j5 = new JTextField();
		j5.setBounds(105,184,150,20);
		j6 = new JTextField();
		j6.setBounds(107,220,150,20);
		ap.add(j1);ap.add(j2);ap.add(j3);ap.add(j4);ap.add(j5);ap.add(j6);

		b1 = new JButton("Add");
		b1.setBounds(77,290,70,30);
		b1.addActionListener(this);
		b2 = new JButton("Back");
		b2.setBounds(150,290,70,30);
		b2.addActionListener(this);
		ap.add(b1);ap.add(b2);
	}//Constructor
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try 
		{
			if (e.getSource() == b1) 
			{

				conection conn = new conection();
				String str = "insert into book(b_id, b_name, b_publisher, b_price, b_pages, dateofissue) values(?, ?, ?, ?, ?, ?)";
				PreparedStatement st = conn.con.prepareStatement(str);
				st.setString(1, j1.getText());
				st.setString(2, j2.getText());
				st.setString(3, j3.getText());
				st.setString(4, j4.getText());
				st.setString(5, j5.getText());
				st.setString(6, j6.getText());

				int i = st.executeUpdate();
				if (i > 0) 
				{
					JOptionPane.showMessageDialog(null, "Book Added Successfully.");
					this.setVisible(false);
					new main().setVisible(true);
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "oooops...!!! somethig went wrong 🤔");
				}
			}//if close 
			if (e.getSource() == b2)
			{
				this.setVisible(false);
				new main().setVisible(true)	;	
			}
		}//try close	
		catch (Exception e1) {e1.printStackTrace();}
	}//action close close

	public static void main(String[] args) 
	{
		new AddBook();
	}

}
