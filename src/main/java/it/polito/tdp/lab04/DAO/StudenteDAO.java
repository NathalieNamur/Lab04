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

	
	//METODO PER OTTENERE TUTTI I CORSI A CUI E' ISCRITTO UN DATO STUDENTE (matricola:
	public List<Corso> getCorsiByStudente(int matricola) {
			
		//Stringa contenente la query:
		final String sql = "SELECT * FROM iscrizione i , corso c "
						   + "WHERE i.codins = c.codins "
					       + "AND matricola=?";

		//Struttura dati dei valori di ritorno:
		List<Corso> corsiByStudente = new LinkedList<Corso>();

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
							
				//Creazione di un Corso temporaneo
				//in cui salvare la riga del database letta:
				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				Corso cTemp = new Corso(codins, numeroCrediti, nome, periodoDidattico);
							
				//Inserimento di tale Corso nella struttura dati risultante:
				corsiByStudente.add(cTemp);
			}

			//Chiusura di tutti gli elementi:
			conn.close();
						
			//Return della struttura dati creata:
			return corsiByStudente;
						
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
			
	}

	
	//METODO PER CONTROLLARE SE UNO STUDENTE (matricola) E' ISCRITTO AD UN CORSO:
	public boolean isStudenteIscrittoACorso(int matricola, Corso corso) {
		
		//Stringa contenente la query:
		final String sql = "SELECT * FROM iscrizione i "
						 + "WHERE matricola = ? "
						 + "AND codins = ?";

		//Valore di ritorno:
		boolean studenteIscrittoACorso = false; //NB: inizializzazione!

		//Codice di accesso effettivo al database (try-catch):
		try {
								
			//Connessione:
			Connection conn = ConnectDB.getConnection();
								
			//PreparedStatement:
			PreparedStatement st = conn.prepareStatement(sql);

			//Inserire paramentri nella query (metodo set corretto):
			st.setInt(1, matricola);
			st.setString(2, corso.getCodins());
								
			//Esecuzione della query e salvataggio del risultato:
								
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
									
				//Creazione del valore di ritorno:
				studenteIscrittoACorso = true;
						
			}

			//Chiusura di tutti gli elementi:
			conn.close();
								
			//Return della struttura dati creata:
			return studenteIscrittoACorso;
								
		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
	}

	
	
}
