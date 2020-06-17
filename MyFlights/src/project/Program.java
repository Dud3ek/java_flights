package project;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Program {

	static Logger logger = Logger.getLogger(Program.class);
	
	public static void main(String[] args) {	
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("NEW PROGRAM STARTUP +++++++++++++++++");
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUI.createGUI();
			}
		});

	}

}
