SET foreign_key_checks = 0;
DROP TABLE IF EXISTS Reservations, UserData, FlightsData, Airports, City;

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
	FlightDate	DATETIME	NOT NULL,
	Airlines	VARCHAR(20) NOT NULL,
	FreeSeats	INT		NOT NULL,
	Price		FLOAT(2) NOT NULL,
	PRIMARY KEY (ID)
	
)ENGINE=InnoDB;


CREATE TABLE Airports
( 
	IATA_code	CHAR(3),
	Name		VARCHAR(100) NOT NULL,
	City_IATA_code	CHAR(3) NOT NULL,
	PRIMARY KEY(IATA_CODE)	
);

CREATE TABLE City
( 
	City_IATA_code	CHAR(3),
	Name		VARCHAR(20) NOT NULL,
	Country		Varchar(20) NOT NULL,
	PRIMARY KEY(City_IATA_code)	
);


CREATE TABLE Reservations
(
	ReservationID	INT AUTO_INCREMENT,
	Username		VARCHAR(12) 	NOT NULL,
	FlightID		INT	NOT NULL,
	NumberOfTickets INT NOT NULL,
	PRIMARY KEY(ReservationID)
	
) ENGINE=InnoDB;

ALTER TABLE FlightsData ADD FOREIGN KEY (Origin) REFERENCES Airports(IATA_code);
ALTER TABLE FlightsData ADD FOREIGN KEY (Destination) REFERENCES Airports(IATA_code);
ALTER TABLE Reservations ADD FOREIGN KEY (Username) REFERENCES UserData(Username);
ALTER TABLE Reservations ADD FOREIGN KEY (FlightID) REFERENCES FlightsData(ID);
ALTER TABLE Airports ADD FOREIGN KEY (City_IATA_code) REFERENCES City(City_IATA_code);

INSERT INTO UserData VALUES 
("admin","adminPass","AdminName", "AdminSurname","admin@myflights.com"),
("Jan1345","Jan1345","Jan","Kowalski","JanKowal@interia.pl");

INSERT INTO FlightsData (Origin, Destination, FlightDate, Airlines, FreeSeats,Price) VALUES
("KRK","WWA", '2020-08-13 14:11:00', "LOT", 150, 130.99),
("LHR","BGY", '2020-08-13 15:13:00', "LOT", 150, 130.99),
("LCY","EWR",'2020-08-14 15:30',"LOT",200,2300),
("WWA","JFK",'2020-08-15 15:30',"LOT",34,2100);


INSERT INTO Airports  VALUES
("KRK","John Paul II International Airport Kraków–Balice","KRK"),
("WAW","Warsaw Chopin Airport","WAW"),
("LHR","London Heathrow","LON"),
("LGW","London Gatwick","LON"),
("STN","London Stansted","LON"),
("LTN","London Luton","LON"),
("SEN","London Southend","LON"),
("LCY","London City","LON"),
("MXP","Milan Malpensa","MIL"),
("Linate","Milan Linate","MIL"),
("BGY","Milan Orio al Serio","MIL"),
("JFK","John F. Kennedy","NYC"),
("LGA","LaGuardia Airport","NYC"),
("EWR","Newark","NYC");

INSERT INTO City VALUES
("KRK","Kraków","Poland"),
("WAW","Warszawa","Poland"),
("LON","London","England"),
("MIL","Milan","Italy"),
("NYC","New York City","USA");


INSERT INTO Reservations (Username,FlightID,NumberOfTickets) VALUES
("admin","1","2"),
("Jan1234","1","1");
