import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class Login {

	String username;
	String password;
	
	public Login(String n_username, String n_password)
	{
		username = n_username;
		password = n_password;
	}
	
	public void logging() {
	String Sql = "Select * from UserData where Login=? AND Password=? ";
	
	try {
			java.sql.Connection conn = DBConnection.ConnectDB();
			PreparedStatement stmt = conn.prepareStatement(Sql);
			stmt.setString(1,username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()==true)
			{
				JOptionPane.showMessageDialog(null, "You are logged");
			}
			else {
				JOptionPane.showMessageDialog(null, "Authentication failure");
			}			
		
			conn.close();
				
			
		}
	catch(Exception e1){
			JOptionPane.showMessageDialog(null, e1);
		}
	}
}
