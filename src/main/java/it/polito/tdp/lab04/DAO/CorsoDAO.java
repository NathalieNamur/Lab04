package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;


public class CorsoDAO {
	
	//METODO PER OTTENERE TUTTI I CORSI SALVATI NEL DB:
	public List<Corso> getTuttiICorsi() {

		//Stringa contenente la query:
		final String sql = "SELECT * FROM corso";

		//Struttura dati dei valori di ritorno:
		List<Corso> corsi = new LinkedList<Corso>();

		//Codice di accesso effettivo al database (try-catch):
		try {
			
			//Connessione:
			Connection conn = ConnectDB.getConnection();
			
			//PreparedStatement:
			PreparedStatement st = conn.prepareStatement(sql);

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
				corsi.add(cTemp);
			}

			//Chiusura di tutti gli elementi:
			conn.close();
			
			//Return della struttura dati creata:
			return corsi;
			

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db", e);
		}
	}
	

	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public void getCorso(Corso corso) {
		// TODO
	}

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public void getStudentiIscrittiAlCorso(Corso corso) {
		// TODO
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
