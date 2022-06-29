package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	//METODO PER OTTENERE LO STUDENTE DATA LA MATRICOLA
	public Studente getStudente(int matricola) {
		
		//Stringa contenente la query:
		final String sql = "SELECT * FROM studente where matricola=?";

		//Valore di ritorno:
		Studente studente = null;

		//Codice di accesso effettivo al database (try-catch):
		try {
					
			//Connessione:
			Connection conn = ConnectDB.getConnection();
					
			//PreparedStatement:
			PreparedStatement st = conn.prepareStatement(sql);

			//Inserire paramentri nella query (metodo set corretto):
			st.setInt(1, matricola);
			
			//Esecuzione della query e salvataggio del risultato:
					
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				//Creazione dello studente cercato:
				studente = new Studente(matricola, rs.getString("cognome"), rs.getString("nome"));
			}

			//Chiusura di tutti gli elementi:
			conn.close();
					
			//Return del valore creato:
			return studente;
					
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
	}

	
	
}
