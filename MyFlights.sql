#--Login: bduchno1	Hasło: ATdasTsLbXtUn6ur	Baza: bduchno1
DROP TABLE IF EXISTS UserData, FlightsData, Airports, Reservations;



CREATE TABLE UserData
( 
	
	Username	VARCHAR(12),
	Password	VARCHAR(12)	NOT NULL,
	Name		VARCHAR(20)	NOT NULL,
	Surname		VARCHAR(20) NOT NULL,
	Email		VARCHAR(30) NOT NULL,
	PRIMARY KEY (Username)
	
);


CREATE TABLE FlightsData
( 
	
	ID			INT	 AUTO_INCREMENT,
	Origin		CHAR(3) NOT NULL,
	Destination	CHAR(3) NOT NULL,
	FlightDate	DATE	NOT NULL,
	Airlines	VARCHAR(20) NOT NULL,
	FreeSeats	INT		NOT NULL,
	Price		FLOAT(2) NOT NULL,
	PRIMARY KEY (ID)
	
)ENGINE=InnoDB;



CREATE TABLE Airports
( 
	IATA_code	CHAR(3),
	City		VARCHAR(20) NOT NULL,
	Country		VARCHAR(20) NOT NULL,
	PRIMARY KEY(IATA_CODE)	
);


CREATE TABLE Reservations
(
	ReservationID	INT AUTO_INCREMENT,
	Username		VARCHAR(12) 	NOT NULL,
	FlightID		INT	NOT NULL,
	PRIMARY KEY(ReservationID)
	
) ENGINE=InnoDB;


ALTER TABLE FlightsData ADD FOREIGN KEY (Origin) REFERENCES Airports(IATA_CODE);
ALTER TABLE FlightsData ADD FOREIGN KEY (Destination) REFERENCES Airports(IATA_CODE);
ALTER TABLE Reservations ADD FOREIGN KEY (Username) REFERENCES UserData(Username);
ALTER TABLE Reservations ADD FOREIGN KEY (FlightID) REFERENCES FlightsData(ID);

INSERT INTO USERDATA VALUES ("admin","admin","AdminName", "AdminSurname","admin@myflights.com");
