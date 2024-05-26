package LibraryManagementSystem;
import java.sql.*;
 
public class conection 
{
	String url = "jdbc:mysql://localhost:3306/librarymanagementsystem";
	String username = "root";
	String password = "mysql1234";
	Connection con;Statement st;
	
	public conection() 
	{
		try
		{//try close
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		st = con.createStatement();
		}
		catch(Exception e) {System.out.println(e);}
	}//constructor close
	
	public static void main(String[] args) 
	{
		new conection();
		System.out.println("Database Connected");
	}//main close

}// class close 
