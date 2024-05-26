package LibraryManagementSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AboutUs extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5;
	JButton back;

	public AboutUs(){

		setTitle("About Us");
		setSize(700,500);
		setVisible(true);
		setLayout(null);

		l1 = new JLabel("Library");
		l1.setBounds(120,60,70,40);
		l1.setForeground(Color.BLUE);
		Font font1 = new Font(l1.getFont().getName(), Font.PLAIN, 20);
		l1.setFont(font1);

		l2 = new JLabel("Management System");
		l2.setBounds(55,80,200,40);
		l2.setForeground(Color.BLUE);
		Font font2 = new Font(l2.getFont().getName(), Font.PLAIN, 20);
		l2.setFont(font2);
		add(l1);add(l2);

		JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("logo.jpeg")));
		l.setBounds(220, 30, 350, 200);add(l);

		l3 = new JLabel("Contact : +91 7204881689");
		l3.setBounds(50,100,200,70);add(l3);
		l4 = new JLabel("Developed By : SUMIT B");
		l4.setBounds(50,150,200,70);add(l4);

		l5 = new JLabel("<html><p>A Library Management System (LMS) is a software application"
				+ " or system designed to help libraries efficiently manage their operations and"
				+ " resources.It serves as a digital platform to automate various library tasks and "
				+ "streamline the management of library collections, patrons, and administrative"
				+ "processes.</p></html>");
		l5.setBounds(70, 230, 450, 100);
		add(l5);

		back = new JButton("Back");
		back.setBounds(450,360,80,25);
		back.addActionListener(this);
		add(back);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == back)
		{
			this.setVisible(false);
			new main().setVisible(true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AboutUs();
	}
}
