import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//Poka¿ loty, wyszukuj je po atrybutach -> zrobi³em na razie printowanie wyników bo nwm czy to zwracaæ jako liste czy co
public class Flight {

	
	public void ShowFlights() {	
		try {
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query = "SELECT * FROM FlightsData";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
				while (rs.next()) {
				    for(int i = 1; i <= columnsNumber; i++)
				       System.out.println(rs.getString(i));		 
				}
			conn.close();
			}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
	}
	
	
	public void FilterID(int x)	//Trzeba wymyœliæ sposób jak to filtrowaæ, ¿eby nie pisaæ tysi¹ca funkcji
	{
		try {
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query = "SELECT * FROM FlightsData where ID="+"\"";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
				while (rs.next()) {
				    for(int i = 1; i <= columnsNumber; i++)
				       System.out.println(rs.getString(i));		
				}
			conn.close();
			}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}		
	}
	
}
