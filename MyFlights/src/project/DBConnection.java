package project;
import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class DBConnection {
	
	static Logger logger = Logger.getLogger(DBConnection.class);
	
	public DBConnection() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@SuppressWarnings("deprecation")
	public static Connection ConnectDB()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); //register driver class
			con=DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/bduchno1","bduchno1","ATdasTsLbXtUn6ur");	//create connection object		
			//JOptionPane.showMessageDialog(null,"Connected to database");
			logger.trace("Connect success");
			return con;
		}
		
		catch(Exception e){
			logger.error(e);
			return null;
		}
		
	}
}

