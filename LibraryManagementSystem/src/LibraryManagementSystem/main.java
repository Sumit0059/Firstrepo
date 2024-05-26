package LibraryManagementSystem;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class main extends JFrame implements ActionListener 
{
	JButton b1,b2,b3,b4,b5,b6,b7;
	JLabel l1;
	JMenuBar mb1;
	JMenu m1,m2,m3;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6;
	
	public main()
	{	
		setTitle("Library Management System");
		setVisible(true);
		setLayout(null);
		setSize(1000,600);
		
		l1 = new JLabel("Library Management System");
		Font labelFont = l1.getFont();
		l1.setFont(new Font(labelFont.getName(), Font.BOLD, 20)); 
		l1.setForeground(new Color(255,80,102));
		l1.setBounds(345,20,280,40);
		add(l1);
		
		JMenuBar menuBar = new JMenuBar();
        menuBar.add(Box.createRigidArea(new Dimension(400,100)));
        menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 0), new Color(128, 128, 128)));
        menuBar.setBackground(Color.white);
        menuBar.setBounds(0, 70, 1000, 40);
        add(menuBar);
        
        JMenu record = new JMenu("Record");
        JMenuItem bookdetails = new JMenuItem("Book Details");
        bookdetails.addActionListener(this);
        JMenuItem studentdetails = new JMenuItem("Student Details");
        studentdetails.addActionListener(this);
        record.add(bookdetails);record.add(studentdetails);menuBar.add(record);
        
        JMenu help = new JMenu("Help");
        JMenuItem readme = new JMenuItem("ReadMe");
        readme.addActionListener(this);
        JMenuItem aboutus = new JMenuItem("AboutUs");
        aboutus.addActionListener(this);
        help.add(readme);help.add(aboutus);menuBar.add(help);
        
        JMenu exit = new JMenu("EXIT");
        JMenuItem logout = new JMenuItem("LogOut");
        logout.addActionListener(this);
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.addActionListener(this);
        menuBar.add(exit);exit.add(logout);exit.add(Exit);
        
        JPanel op = new JPanel();
        op.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Operation", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(220, 20, 60)));
        op.setBounds(250, 170, 500, 170);
        op.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(op);
        
        //icon 1
        JLabel l2 = new JLabel("");
        l2.setBounds(10, 10, 130, 100);
        l2.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i1  = new ImageIcon(getClass().getResource("/addbook.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l2 = new JLabel(i3);
        l2.setVisible(true);
        op.add(l2);
        
        //button 1
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(l2);
    	b1 = new JButton("Add Book");
    	b1.addActionListener(this);
    	b1.setMaximumSize(new Dimension(150, 50));
        verticalBox.add(b1);
    	op.add(verticalBox);
		
		//icon 2
    	 JLabel l3 = new JLabel("");
         l3.setBounds(30, 10, 150, 100);
         l3.setVerticalAlignment(SwingConstants.TOP);
         //l3.setHorizontalAlignment(SwingConstants.RIGHT);
         ImageIcon i4  = new ImageIcon(getClass().getResource("/addstudent.jpg"));
         Image i5 = i4.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
         ImageIcon i6 = new ImageIcon(i5);
         l3 = new JLabel(i6);
         l3.setVisible(true);
         op.add(l3);
    	
    	//button b2
        Box vBox = Box.createVerticalBox();
        vBox.add(l3);
		b2 = new JButton("Add Student");
		b2.addActionListener(this);
    	b2.setMaximumSize(new Dimension(150, 50));
        vBox.add(b2);
    	op.add(vBox);
    	
    	//icon 3
    	JLabel l4 = new JLabel("");
        l4.setBounds(30, 10, 150, 100);
        l4.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i7  = new ImageIcon(getClass().getResource("/Statistics.jpg"));
        Image i8 = i7.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        l4 = new JLabel(i9);
        l4.setVisible(true);
        op.add(l4);
    	
        // button 3
        Box vBox1 = Box.createVerticalBox();
        vBox1.add(l4);
		b3 = new JButton("Statistics");
		b3.addActionListener(this);
    	b3.setMaximumSize(new Dimension(150, 50));
        vBox1.add(b3);
    	op.add(vBox1);
        
        
    	JPanel ap = new JPanel();
        ap.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 2), "Action", TitledBorder.LEADING,
		TitledBorder.TOP, null, new Color(220, 20, 60)));
        ap.setBounds(250, 350, 500, 170);
        ap.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(ap);
        
        //icon 4
        JLabel l5 = new JLabel("");
        l5.setBounds(30, 10, 150, 100);
        l5.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i10 = new ImageIcon(getClass().getResource("/issuebook.jpg"));
        Image i11 = i10.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        l5 = new JLabel(i12);
        l5.setVisible(true);
        ap.add(l5);
	
        //button 4
        Box vBox2 = Box.createVerticalBox();
        vBox2.add(l5);
		b4 = new JButton("Issue Book");
		b4.addActionListener(this);
    	b4.setMaximumSize(new Dimension(150, 50));
        vBox2.add(b4);
    	ap.add(vBox2);
    	
    	//icon 5
    	JLabel l6 = new JLabel("");
        l6.setBounds(30, 10, 150, 100);
        l6.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i13 = new ImageIcon(getClass().getResource("/returnbook.jpg"));
        Image i14 = i13.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        l6 = new JLabel(i15);
        l6.setVisible(true);
        ap.add(l6);
    	
        // button 5
        Box vBox3 = Box.createVerticalBox();
        vBox3.add(l6);
		b5 = new JButton("Return Book");
		b5.addActionListener(this);
    	b5.setMaximumSize(new Dimension(150, 50));
        vBox3.add(b5);
    	ap.add(vBox3);
		
    	//icon 6
    	JLabel l7 = new JLabel("");
        l7.setBounds(30, 10, 150, 100);
        l7.setVerticalAlignment(SwingConstants.TOP);
        ImageIcon i16 = new ImageIcon(getClass().getResource("/aboutus.jpg"));
        Image i17 = i16.getImage().getScaledInstance(150, 100,Image.SCALE_DEFAULT);
        ImageIcon i18 = new ImageIcon(i17);
        l7 = new JLabel(i18);
        l7.setVisible(true);
        ap.add(l7);
    	
    	//button 6
        Box vBox4 = Box.createVerticalBox();
        vBox4.add(l7);
		b6 = new JButton("About us");
		b6.addActionListener(this);
    	b6.setMaximumSize(new Dimension(150, 50));
        vBox4.add(b6);
    	ap.add(vBox4);
    	
    	b7 = new JButton("Home");
    	b7.setBounds(890,110,80,30);
    	b7.addActionListener(this);
    	add(b7);
	}// constructor close
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String msg = e.getActionCommand();
		 //System.out.println("Action Command: " + msg);
		if (msg.equals("Exit")) {
			 //System.out.println("Exit clicked");
			System.exit(0);
		}
		else if(msg.equals("LogOut")) {
			this.setVisible(false);
			new login().setVisible(true);
		}
		else if(msg.equals("Book Details")) {
			this.setVisible(false);
			new BookDetails().setVisible(true);
		}
		else if (msg.equals("Student Details")) {
			this.setVisible(false);
			new StudentDetails().setVisible(true);
		}
		else if (msg.equals("AboutUs")) {
			this.setVisible(false);
			new AboutUs().setVisible(true);
		}
		
		if (e.getSource() == b1) {
			this.setVisible(false);
			new AddBook().setVisible(true);
		}
		if (e.getSource() == b2) {
			this.setVisible(false);
			new AddStudent().setVisible(true);
		}
		if (e.getSource() == b3) {
			this.setVisible(false);
			new statistics().setVisible(true);
		}
		if (e.getSource() == b4) {
			this.setVisible(false);
			new IssueBook().setVisible(true);
		}
		if (e.getSource() == b5) {
			this.setVisible(false);
			new ReturnBook().setVisible(true);
		}
		if (e.getSource() == b6) {
			this.setVisible(false);
			new AboutUs().setVisible(true);
		}
		if (e.getSource() == b7) {
			this.setVisible(false);
			new login().setVisible(true);
		}
	}// actionperformed close
	public static void main(String[] args) 
	{
		new main();
	}
}