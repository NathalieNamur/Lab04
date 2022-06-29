package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	//1.Definire la stringa di connessione JDBC:
	static private final String jdbcUrl = "jdbc:mysql://localhost/iscritticorsi?user=root&password=moustache";

	//2.Aprire una connessione (try):
	public static Connection getConnection() {

		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}

}
