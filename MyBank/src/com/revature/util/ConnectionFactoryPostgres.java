package com.revature.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;



public final class ConnectionFactoryPostgres {
	
		
		Logger log = Logger.getRootLogger();

		public static String URL;

		public static String USERNAME;

		public static String PASSWORD;
		
		// only instance of this class that can ever exist inside of program
		private static ConnectionFactoryPostgres connectionFactory = null;
		
		//private constructor, lazy loading because it doesn't actually get set unless actually using the connection to the database.
		private ConnectionFactoryPostgres() {
		
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Failed to load Driver");
//		}
		
		URL = "jdbc:postgresql://" + System.getenv("BANK_DB_URL") + ":5432/" +"postgres" + "?";
		
		USERNAME = System.getenv("BANK_DB_USERNAME");

		PASSWORD = System.getenv("BANK_DB_PASSWORD");
		
//		try {
//			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
//		} catch (SQLException e) {
//			log.error("Failed to connect to Database",e);
//			//e.printStackTrace();
//		}
//		return null;
	}
		public Connection createConnection() {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("Failed to load Driver");
			}

			log.info("URL : " + URL);

			try {
				return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (SQLException e) {
				log.error("Failed to connect to DB", e);
			}
			return null;
		}
		

		public static synchronized Connection getConnection() {
			
			if (connectionFactory == null) {
				connectionFactory = new ConnectionFactoryPostgres();
			}

			return connectionFactory.createConnection();

		}

}

