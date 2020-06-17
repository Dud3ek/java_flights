package project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Flight {

	static Logger logger = Logger.getLogger(Flight.class);
	
	public Flight() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static ResultSet ShowFlights(java.sql.Connection conn) {	
		try {
			logger.trace("Show flight in progress");
			String query = "SELECT * FROM FlightsData";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
			}
		catch(Exception e1){
			logger.error(e1);
			}
		return null;
	}
	
	
	public static ResultSet ShowOrderedFlights(String sort, java.sql.Connection conn)	
	{

		try {
			logger.trace("Show ordered flights in progress");
			String query = "SELECT * FROM FlightsData ORDER BY "+sort; 
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
		}
			catch(Exception e1){
				logger.error(e1);}	
			return null;
		
	}
	
}
