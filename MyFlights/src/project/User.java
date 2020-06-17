package project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class User {
	
	static Logger logger = Logger.getLogger(User.class);
	
	String username = new String();
	public int op = 0;

	public User(){
		PropertyConfigurator.configure("log4j.properties");
		logger.trace("User profile logger initialized");
	}
	
	public void Login(String n_username,String n_password)
	{
		try {
			logger.trace("Login started");
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query = "SELECT Username,Password FROM UserData where Username=\""+n_username+"\"AND Password=\""+n_password+"\"";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
				if(rs.next()==true)
				{
					logger.info("Login sucess");
					JOptionPane.showMessageDialog(null, "You are logged");
					username=n_username;
					op = 1;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Authentication failure");
					logger.error("Authentication failure");
				}	
				conn.close();	
			}
		catch(Exception e1)	{JOptionPane.showMessageDialog(null, "Connection failure");
		logger.error(e1);}
	}
	
	public void Register(String n_username,String n_password,String n_name, String n_surname, String n_email )
	{
		String checkIsFreeQuery = "SELECT Username,Password FROM UserData where Username=\""+n_username+"\"AND Password=\""+n_password+"\"";
		String addUserQuery = "Insert INTO UserData (Username, Password, Name, Surname, Email)" + "VALUES (?,?,?,?,?)";
		try {
				logger.trace("Starting registration procedure");
				java.sql.Connection conn = DBConnection.ConnectDB();
				PreparedStatement stmt = conn.prepareStatement(checkIsFreeQuery);
				PreparedStatement stmt2 = conn.prepareStatement(addUserQuery);
				stmt2.setString(1, n_username);
				stmt2.setString(2, n_password);
				stmt2.setString(3, n_name);
				stmt2.setString(4, n_surname);
				stmt2.setString(5, n_email);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()==true)
				{
					JOptionPane.showMessageDialog(null, "This username is taken");
					logger.info("Username taken");
				}
				else 
				{
					if(stmt2.executeUpdate()>0)
					{
						logger.info("New user added");
						JOptionPane.showMessageDialog(null, "New User Add");
						username=n_username;
					}
					else 
					{
						logger.error("Error during addition of user");
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}			
				}		
				conn.close();		
			}	
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
	}
	
	public ResultSet ShowUserData(java.sql.Connection conn)
	{
			try {
				logger.trace("User data function started");
				String query = "SELECT * FROM UserData where Username=\""+username+"\"";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				return rs;
				}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
		
		return null;			
	}
	
	public void ChangePassword(String oldPassword, String newPassword)
	{
		try {
			logger.trace("Change password called properly");
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query = "UPDATE UserData SET Password=? where Username=\""+username+"\"AND Password=\""+oldPassword+"\"";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.executeUpdate();	
			conn.close();
			JOptionPane.showMessageDialog(null, "Change of password");
		}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
	}
}
