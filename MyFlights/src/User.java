import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//Metody zwi¹zane z Userem i jego danymi -> Tu chyba wszystko
public class User {
	
	String username = new String();
	

	public void Login(String n_username,String n_password)
	{
		try {
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query = "SELECT Username,Password FROM UserData where Username=\""+n_username+"\"AND Password=\""+n_password+"\"";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			
				if(rs.next()==true)
				{
					JOptionPane.showMessageDialog(null, "You are logged");
					username=n_username;
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Authentication failure");
				}
				conn.close();	
				
			}
		catch(Exception e1)	{JOptionPane.showMessageDialog(null, e1);}
	}
	
	public void Register(String n_username,String n_password,String n_name, String n_surname, String n_email )
	{
		String checkIsFreeQuery = "SELECT Username,Password FROM UserData where Username=\""+n_username+"\"AND Password=\""+n_password+"\"";
		String addUserQuery = "Insert INTO UserData (Username, Password, Name, Surname, Email)" + "VALUES (?,?,?,?,?)";
		try {
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
				}
				else 
				{
					if(stmt2.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "New User Add");
						username=n_username;
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Something went wrong");
					}			
				}		
				conn.close();		
			}	
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
	}
	
	public ArrayList<String> ShowUserData()
	{
		ArrayList<String> DataList = new ArrayList<String>();
			try {
				java.sql.Connection conn = DBConnection.ConnectDB();
				String query = "SELECT * FROM UserData where Username=\""+username+"\"";
				PreparedStatement stmt = conn.prepareStatement(query);
				ResultSet rs = stmt.executeQuery();
				ResultSetMetaData rsmd = rs.getMetaData();
				int columnsNumber = rsmd.getColumnCount();
					while (rs.next()) {
					    for(int i = 1; i <= columnsNumber; i++)
					       DataList.add(rs.getString(i));		  
					}
				conn.close();
				}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
		
		return DataList;			
	}
	
	public void ChangePassword(String oldPassword, String newPassword)
	{
		try {
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query = "UPDATE UserData SET Password=? where Username=\""+username+"\"AND Password=\""+oldPassword+"\"";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.executeUpdate();	
			conn.close();
		}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
	}
}
