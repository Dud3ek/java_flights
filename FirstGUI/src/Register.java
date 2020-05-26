import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Register {

	String username;
	String password;
	
	public Register(String n_username, String n_password)
	{
		username = n_username;
		password = n_password;
	}
	
	public void registering() {
	String checkIsFree = "Select * from UserData WHERE Login = ? AND Password = ?";
	String addUser = "Insert INTO UserData (Login, Password)" + "VALUES (?,?)";
	
	
	try {
			java.sql.Connection conn = DBConnection.ConnectDB();
			PreparedStatement stmt = conn.prepareStatement(checkIsFree);
			PreparedStatement stmt2 = conn.prepareStatement(addUser);
			stmt.setString(1,username);
			stmt.setString(2, password);
			stmt2.setString(1, username);
			stmt2.setString(2, password);
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
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Something went wrong");
				}			
			}		
		
			
		
			conn.close();
				
			
		}
	catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
	}
}