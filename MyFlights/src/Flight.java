import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//Poka¿ loty, wyszukuj je po atrybutach -> zrobi³em na razie printowanie wyników bo nwm czy to zwracaæ jako liste czy co
public class Flight {

	
	public static ResultSet ShowFlights(java.sql.Connection conn) {	
		try {
			
			String query = "SELECT * FROM FlightsData";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
			
			}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}
		return null;
	}
	
	
	public ResultSet ShowOrderedFlights(int x, java.sql.Connection conn)	//Trzeba wymyœliæ sposób jak to filtrowaæ, ¿eby nie pisaæ tysi¹ca funkcji
	{
		String param = new String();
		try {
			switch(x) {
			
				case 1:
					param="ID";
					break;	
				case 2:
					param="Origin";
					break;				
				case 3:
					param="Destination";
					break;			
				case 4:
					param="FlightDate";
					break;
				case 5:
					param="Airlines";
					break;
				case 6:
					param="FreeSeats";
					break;
				case 7:
					param="Price";
					break;			
			}
			String query = "SELECT * FROM FlightsData where ID="+"\" ORDER BY "+param; 
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
		}
			catch(Exception e1){JOptionPane.showMessageDialog(null, e1);}	
			return null;
		
	}
	
}
