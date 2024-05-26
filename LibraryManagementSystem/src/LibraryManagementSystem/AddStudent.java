package LibraryManagementSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddStudent extends JFrame implements ActionListener 
{
	JLabel l1,l2,l3,l4,l5;
	JTextField j1,j2,j3,j4,j5;
	JButton b1,b2;	
	AddStudent()
	{
		setTitle("Add Student");
		setVisible(true);
		setLayout(null);
		setSize(500,400);
		
		JPanel ap = new JPanel();
        ap.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Add Student Details", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(220, 20, 60)));
        ap.setBounds(80, 40, 300, 290);
        ap.setLayout(null);
        add(ap);
        
        l1 = new JLabel("Student id :");
        l1.setBounds(15,25,100,20);
        l2 = new JLabel("Student Name :");
        l2.setBounds(15,70,100,20);
        l3 = new JLabel("Student branch :");
        l3.setBounds(15,110,100,20);
        l4 = new JLabel("Student Year :");
        l4.setBounds(15,148,100,20);
        l5 = new JLabel("Student Sem :");
        l5.setBounds(15,184,100,20);
        ap.add(l1);ap.add(l2);ap.add(l3);ap.add(l4);ap.add(l5);
        
        j1 = new JTextField();
        j1.setBounds(93,26,150,20);
        j2 = new JTextField();
        j2.setBounds(110,70,150,20);
        j3 = new JTextField();
        j3.setBounds(115,110,150,20);
        j4 = new JTextField();
        j4.setBounds(110,148,150,20);
        j5 = new JTextField();
        j5.setBounds(110,184,150,20);
        ap.add(j1);ap.add(j2);ap.add(j3);ap.add(j4);ap.add(j5);
        
        b1 = new JButton("Add");
        b1.setBounds(77,250,70,30);
        b2 = new JButton("back");
        b2.setBounds(150,250,70,30);
        b1.addActionListener(this);
        b2.addActionListener(this);
        ap.add(b1);ap.add(b2);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
		if (e.getSource() == b1) {
			conection conn = new conection();
			String str = "insert into student(s_id, s_name, s_branch, s_year, s_sem) values(?,?,?,?,?)";
			PreparedStatement st = conn.con.prepareStatement(str);
			
			st.setString(1, j1.getText());
			st.setString(2, j2.getText());
			st.setString(3, j3.getText());
			st.setString(4, j4.getText());
			st.setString(5, j5.getText());
			
			int i = st.executeUpdate();
			if (i>0) {
				JOptionPane.showMessageDialog(rootPane, "Student Added Successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "oooops...!!!! something went wrong 🤔");
			}
		}//b1 close 
		}  catch(Exception e1) {System.out.println(e1);}
		
		if (e.getSource() == b2) {
			this.setVisible(false);
			new main().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new AddStudent();
	}
}
