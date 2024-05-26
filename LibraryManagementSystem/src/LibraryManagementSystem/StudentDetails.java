package LibraryManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

public class StudentDetails extends JFrame implements ActionListener
{
	JTable t1;
	DefaultTableModel model;
	JButton back;
	
	public StudentDetails()
	{
		setTitle("Student Details");
		setVisible(true);
		setLayout(null);
		setSize(800,500);
		
		back = new JButton("↩");
		back.setBounds(20,20,45,30);
		back.addActionListener(this);
		add(back);

		JPanel op = new JPanel();
		op.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Student-Details", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(220, 20, 60)));
		op.setBounds(20, 50, 598, 298);
		add(op);

		t1 = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(t1);
		scrollPane.setPreferredSize(new Dimension(570, 260));
		op.add(scrollPane);
		fetchdata();

	} //constructor close

	public void fetchdata()
	{
		SwingUtilities.invokeLater(() -> {
			try 
			{
				model = new DefaultTableModel(new Object[]{"Student-ID","Student-Name","Student_branch","Student_Year","Student_Sem"}, 0);
				conection conn = new conection();
				String str = "select * from student"; 
				PreparedStatement st = conn.con.prepareStatement(str);
				ResultSet rs = st.executeQuery();

				while(rs.next())
				{
					Object[] rowdata = {
							rs.getObject("s_id"),
							rs.getObject("s_name"),
							rs.getObject("s_branch"),
							rs.getObject("s_year"),
							rs.getObject("s_sem"),
					};
					model.addRow(rowdata); 
				}
				t1.setModel(model);
			}
			catch(Exception e) {e.printStackTrace();}
		});
	}

	public static void main(String[] args) {
		new StudentDetails();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == back)
		{
			this.setVisible(false);
			new main().setVisible(true);
		}
	}

}
