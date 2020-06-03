import java.sql.*;
import javax.swing.*;

public class DBConnection {
	
	@SuppressWarnings("deprecation")
	public static Connection ConnectDB()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //register driver class
			con=DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/bduchno1","bduchno1","ATdasTsLbXtUn6ur");	//create connection object		
			//JOptionPane.showMessageDialog(null,"Connected to database");
			return con;
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}
}

