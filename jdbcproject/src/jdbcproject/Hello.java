package jdbcproject;

import java.sql.*;

public class Hello {

	public static void main(String[] args) throws Exception {
	
		Connection myConn = getConnection();
		
		try {
			Statement myS = myConn.createStatement();
			ResultSet myRS = myS.executeQuery("select * from books");
			while(myRS.next()) {
				System.out.println(myRS.getString("topic"));
			}
		}
		
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}

	public static Connection getConnection() throws Exception{
		try {
//			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://mysql.agh.edu.pl:3306/mdudzik";
			String username = "mdudzik";
			String password = "fTDoSSAqBZR1AAz2";
//			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.println("Connected");
			return conn;
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return null;
	}
}
