package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class ConnectDB {
	
	
	//1.Definire la stringa di connessione JDBC:
	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=moustache";

	//2.Aprire una connessione (try-catch):
	public static Connection getConnection() {

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			return connection;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
		
	}
	
	
	

	
	/**
	
	//CONNECTION POOLING (PATTERN ORM): 
	
	//I.
	static private HikariDataSource ds = null; 
	static private String url = "jdbc:mysql://localhost:3306/iscritticorsi?user=root&password=moustache";
		
	//II.
	public static Connection getConnection() {
			
		//La datasource è già stata aperta (esiste)?
			
		//Se la ds non esiste ancora, bisogna crearla:
			
		if(ds==null) {
			ds = new HikariDataSource();
			ds.setJdbcUrl(url);
			ds.setUsername("root");
			ds.setPassword("moustache");
		}
			
		//Per poi restituire una nuova connessione 
		//dalla ds appena creata:
			
		try {
			return ds.getConnection();
				
		} catch (SQLException e) {
			System.out.println("ERRORE di connessione al database.");
			e.printStackTrace();
			return null;
		}
			
	}
	
	*/
	
	
	
}
