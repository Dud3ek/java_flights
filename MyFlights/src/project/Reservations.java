package project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Reservations {

	static Logger logger = Logger.getLogger(Reservations.class);
	
	public Reservations() {
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static void Reserve(String username, int FlightID,int numberOfTickets )
	{
		try {
			logger.trace("Reserving...");
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query1 = "SELECT FreeSeats FROM FlightsData where ID=?";
			String query2 = "Insert INTO Reservations (Username, FlightID,NumberOfTickets) VALUES (?,?,?)";
			String query3 = "UPDATE FlightsData SET FreeSeats=FreeSeats-? where ID=?";
			PreparedStatement stmt1 = conn.prepareStatement(query1);
			PreparedStatement stmt2 = conn.prepareStatement(query2);
			PreparedStatement stmt3 = conn.prepareStatement(query3);
			stmt1.setInt(1,FlightID);
			stmt2.setString(1, username);
			stmt2.setInt(2, FlightID);
			stmt2.setInt(3, numberOfTickets);
			stmt3.setInt(1, numberOfTickets);
			stmt3.setInt(2, FlightID);
			ResultSet rs = stmt1.executeQuery();
			rs.next();
			if(rs.getInt(1)>=numberOfTickets)
			{
				stmt2.executeUpdate();	
				stmt3.executeUpdate();
				JOptionPane.showMessageDialog(null, "Ticket reserved!");
				logger.info("Tickets reserved");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "There is no enough free tickets anymore");
				logger.error("Not enough free tickets");
			}
			
			conn.close();
		}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
	}
	public static void CancelReservation(String username, int ReservationID)
	{
		try {
			logger.trace("Cancel reservation in progress");
			java.sql.Connection conn = DBConnection.ConnectDB();
			String query1 = "SELECT Username, NumberOfTickets, FlightID FROM Reservations where ReservationID=?";//sprawdz czy username siê zgadza i pobierz ile miejsc zarezerwowanych
			String query2 = "DELETE FROM Reservations WHERE ReservationID=?";//je¿eli user usuwa swoja rezerwacje to usuñ jej wiersz w Reservations
			String query3 = "UPDATE FlightsData SET FreeSeats=FreeSeats+? where ID=?";//nastêpnie dodaj wolne miejsca do lotu
			PreparedStatement stmt1 = conn.prepareStatement(query1);
			PreparedStatement stmt2 = conn.prepareStatement(query2);
			PreparedStatement stmt3 = conn.prepareStatement(query3);
			stmt1.setInt(1,ReservationID);
			stmt2.setInt(1, ReservationID);
		
			ResultSet rs = stmt1.executeQuery();
			rs.next();
			
			if(username.equalsIgnoreCase(rs.getString(1)))
			{
				stmt3.setInt(1, rs.getInt(2));
				stmt3.setInt(2, rs.getInt(3));
				stmt2.executeUpdate();	
				stmt3.executeUpdate();
				JOptionPane.showMessageDialog(null, "Reservation cancelled!");
				logger.info("Reservation cancelled");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong ID number!");
				logger.error("Wrong ID number, other user reservation");
			}
			
			conn.close();
		}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
	}
	public static ResultSet ShowAllReservations(java.sql.Connection conn) {	
		try {
			logger.trace("Showing all reservation in progress");
			String query = "SELECT * FROM Reservations";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
			
			}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
		return null;
	}
	public static ResultSet ShowUserReservations(java.sql.Connection conn, String username) {	
		try {
			logger.trace("Showing user reservations in progress");
			String query = "SELECT * FROM Reservations where Username=\""+username+"\"";
			PreparedStatement stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			return rs;
			
			}
		catch(Exception e1){JOptionPane.showMessageDialog(null, e1);
		logger.error(e1);}
		return null;
	}
	
}
