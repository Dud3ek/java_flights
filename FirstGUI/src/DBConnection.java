import java.sql.*;

import javax.swing.*;
public class DBConnection {

	
	//https://www.youtube.com/watch?v=BAege1_oi9w
	@SuppressWarnings("deprecation")
	public static Connection ConnectDB()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //register driver class
			con=DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/bduchnow","bduchnow","xt7jP2HZSUb9Tp1c");	//create connection object		
			//JOptionPane.showMessageDialog(null,"Connected to database");
			return con;
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
		
	}


