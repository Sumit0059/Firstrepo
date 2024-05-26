package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.cj.protocol.Resultset;

public class statistics extends JFrame implements ActionListener
{
	JTable booktable, studenttable;
	DefaultTableModel bookmodel,studentmodel;
	Object swingUtilities;
	JButton back, clear;

	public statistics()
	{
		setTitle("Statistics");
		setVisible(true);
		setLayout(null);
		setSize(1000,620);

		JLabel l1 = new JLabel("Statics Of The Library");
		Font labelFont = l1.getFont();
		l1.setFont(new Font(labelFont.getName(), Font.BOLD, 20)); 
		l1.setForeground(new Color(255,80,102));
		l1.setBounds(345,20,280,40);
		add(l1);

		JPanel op = new JPanel();
		op.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Issued-Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		op.setBounds(20, 80, 734, 230);
		op.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(op);

		booktable = new JTable(bookmodel);
		JScrollPane first = new JScrollPane(booktable);
		first.setPreferredSize(new Dimension(707, 200));
		op.add(first);
		bookfetch();

		JPanel ap = new JPanel();
		ap.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Returned-Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(220, 20, 60)));
		ap.setBounds(20, 330, 734, 230);
		ap.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(ap);

		studenttable = new JTable(studentmodel);
		JScrollPane second = new JScrollPane(studenttable);
		second.setPreferredSize(new Dimension(707, 200));
		ap.add(second);		
		studentfetch();
		
		back = new JButton("↩");
		back.setBounds(22,20,45,30);
		back.addActionListener(this);
		add(back);
	}// constructor close

	public void bookfetch()
	{
		SwingUtilities.invokeLater(() ->
		{
			try 
			{
				bookmodel = new DefaultTableModel(new Object[]{"Book-ID","Book-Name","Student_ID","Student_Name","Student_Branch","Student-Year","Student-Sem","DateOfIssue"}, 0);
				conection conn = new conection();
				String str = "select * from issuebook";
				PreparedStatement st = conn.con.prepareStatement(str);
				ResultSet rs = st.executeQuery();

				while(rs.next())
				{
					Object[] rowdata = {
							rs.getObject("b_id"),
							rs.getObject("b_name"),
							rs.getObject("s_id"),
							rs.getObject("s_name"),
							rs.getObject("s_branch"),
							rs.getObject("s_year"),
							rs.getObject("s_sem"),
							rs.getObject("dateofissue"),
					};
					bookmodel.addRow(rowdata); 
				}
				booktable.setModel(bookmodel);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(rootPane, "Error : "+e, "Warning",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		});
	}// table 1 close

	public void studentfetch() 
	{
		SwingUtilities.invokeLater(() ->
		{
			try
			{
				studentmodel = new DefaultTableModel(new Object[]{"Book-ID","Book-Name","Student_ID","Student_Name","Student_Branch","Student-Year","Student-Sem","DateOfIssue"}, 0);
				conection conn = new conection();
				String str = "select * from returnbook";
				PreparedStatement st = conn.con.prepareStatement(str);
				ResultSet rs = st.executeQuery();  

				while(rs.next()) 
				{
					Object[]  rowdata = {
							rs.getObject("b_id"),
							rs.getObject("b_name"),
							rs.getObject("s_id"),
							rs.getObject("s_name"),
							rs.getObject("s_branch"),
							rs.getObject("s_year"),
							rs.getObject("s_sem"),
							rs.getObject("dateofissue"),
					};
					studentmodel.addRow(rowdata);
				}// while close
				studenttable.setModel(studentmodel);
			}//try close
			catch(SQLException e1) {
				JOptionPane.showMessageDialog(rootPane, "Error : "+e1, "Warning", JOptionPane.ERROR_MESSAGE);
			}
		});
	}//table 2 close



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == back)
		{
			this.setVisible(false);
			new main().setVisible(true);
		}
	}


	public static void main(String[] args) 
	{
		new statistics();
	}
}
