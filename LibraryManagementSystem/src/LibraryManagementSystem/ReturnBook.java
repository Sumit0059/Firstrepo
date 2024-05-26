package LibraryManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.cj.protocol.Resultset;

public class ReturnBook extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField j1,j2,j3,j4,j5,j6,j7,j8;
	JButton b1,b2,b3,b4;

	public ReturnBook()
	{
		setTitle("Return Book");
		setVisible(true);
		setLayout(null);
		setSize(775,550);

		JPanel ap = new JPanel();
		ap.setBorder(new TitledBorder(new LineBorder(new Color(255, 130, 150), 7), "Return-Book", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		ap.setBounds(40, 35, 650, 350);
		ap.setLayout(null);
		add(ap);

		JPanel book = new JPanel();
		book.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Book", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		book.setBounds(20, 30, 300, 200);
		book.setLayout(null);
		ap.add(book);

		l1 = new JLabel("Book-Id :");
		l1.setBounds(20,20,100,30);
		j1 = new JTextField();
		j1.setBounds(90,22,150,25);

		l2 = new JLabel("Book-Name :");
		l2.setBounds(20,70,100,30);
		j2 = new JTextField();
		j2.setBounds(100,72,180,25);

		b1 = new JButton("Search");
		b1.setBounds(110,125,80,28);
		b1.addActionListener(this);
		book.add(b1);book.add(l1);book.add(l2);
		book.add(j1);book.add(j2);

		JPanel student = new JPanel();
		student.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Student", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		student.setBounds(330, 30, 300, 280);
		student.setLayout(null);
		ap.add(student);

		l3 = new JLabel("Student-ID :");
		l3.setBounds(20,20,100,30);
		j3 = new JTextField();
		j3.setBounds(110,24,150,25);

		l4 = new JLabel("Student-Name :");
		l4.setBounds(20,55,100,30);
		j4 = new JTextField();
		j4.setBounds(123,57,150,25);

		l5 = new JLabel("Student-Branch :");
		l5.setBounds(20,95,100,30);
		j5 = new JTextField();
		j5.setBounds(135,98,150,25);

		l6 = new JLabel("Student-Year :");
		l6.setBounds(20,135,100,30);
		j6 = new JTextField();
		j6.setBounds(130,138,150,25);

		l7 = new JLabel("Student-Sem :");
		l7.setBounds(20,170,100,30);
		j7 = new JTextField();
		j7.setBounds(125,173,150,25);

		b2 = new JButton("search");
		b2.addActionListener(this);
		b2.setBounds(100,220,97,30);
		student.add(l3);student.add(l4);student.add(l5);student.add(l6);student.add(l7);student.add(b2);
		student.add(j3);student.add(j4);student.add(j5);student.add(j6);student.add(j7);

		l8 = new JLabel("Date Of Issue :");
		l8.setBounds(20,240,100,30);
		j8 = new JTextField();
		j8.setBounds(120,243,150,25);        

		b3 = new JButton("Return");
		b3.setBounds(50,285,100,30);
		b3.addActionListener(this);
		b4 = new JButton("back");
		b4.setBounds(160,285,100,30);
		b4.addActionListener(this);
		ap.add(l8);ap.add(b3);ap.add(b4);ap.add(j8);

	} // constructor close
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		int row = 0, rowsaffected;

		conection conn = new conection();
		if (e.getSource() == b1)
		{
			try
			{
				String str = "SELECT book.b_name, issuebook.dateofissue FROM book INNER JOIN issuebook ON book.b_id = issuebook.b_id WHERE book.b_id=?";
				System.out.println("Query: " + str);

				PreparedStatement st = conn.con.prepareStatement(str);

				st.setString(1, j1.getText());
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					j2.setText(rs.getString("book.b_name"));
					j8.setText(rs.getString("issuebook.dateofissue"));
				}
				else {JOptionPane.showMessageDialog(rootPane, "book does not exist", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
			}//try close
			catch(SQLException e1) 
			{e1.printStackTrace();
			JOptionPane.showMessageDialog(rootPane, "Error: " + e1.getMessage(), "Information", JOptionPane.ERROR_MESSAGE);

			}
		}//b1 close

		if (e.getSource() == b2)
		{
			try
			{
				String str = "select * from student where s_id=?";
				PreparedStatement st = conn.con.prepareStatement(str);

				st.setString(1,j3.getText());
				ResultSet rs = st.executeQuery();

				if (rs.next()) {
					j4.setText(rs.getString("s_name"));
					j5.setText(rs.getString("s_branch"));
					j6.setText(rs.getString("s_year"));
					j7.setText(rs.getString("s_sem"));
				}
			}//try close
			catch(Exception e1) {e1.printStackTrace();}
		}// b2 close 

		if(e.getSource() == b3)
		{
			try {
				String str = "insert into returnbook(b_id, b_name, s_id, s_name, s_branch, s_year, s_sem, dateofissue) values(?, ?, ?, ?, ?, ?, ?, ?)";
				try (PreparedStatement st = conn.con.prepareStatement(str, Statement.RETURN_GENERATED_KEYS)) {
					st.setString(1, j1.getText());
					st.setString(2, j2.getText());
					st.setString(3, j3.getText());
					st.setString(4, j4.getText());
					st.setString(5, j5.getText());
					st.setString(6, j6.getText());
					st.setString(7, j7.getText());
					st.setString(8, j8.getText());

					// Execute the insert statement
					int rowsAffected = st.executeUpdate();

					if (rowsAffected > 0) 
					{
						// Retrieve the generated keys (if supported)
						try (ResultSet generatedKeys = st.getGeneratedKeys()) 
						{
							if (generatedKeys.next())
							{
								row = generatedKeys.getInt(1);
								String str1 = "delete from issuebook where b_id=?";
								try (PreparedStatement st1 = conn.con.prepareStatement(str1))
								{
									st1.setInt(1, row);
									int j = st1.executeUpdate();s
									if (j > 0) 
									{
										JOptionPane.showMessageDialog(rootPane, "Book Returned successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
									}
									else
									{
										JOptionPane.showMessageDialog(rootPane, "No records found in issuebook for the given b_id", "Warning", JOptionPane.WARNING_MESSAGE);
									}
								}//try close
							} //if close
							else {
								JOptionPane.showMessageDialog(rootPane, "Failed to retrieve the inserted ID", "Information", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "No rows were inserted", "Information", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}  
			catch(Exception e2) {e2.printStackTrace();}
		} //b3 close
		if (e.getSource() == b4)
		{
			this.setVisible(false);
			new main().setVisible(true);
		}//b4 close 
	}//action close

	public static void main(String[] args) 
	{
		new ReturnBook();
	}

}
