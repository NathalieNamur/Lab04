package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {

	//ATTRIBUTI:
	private CorsoDAO corsoDAO; 
	private StudenteDAO studenteDAO;
	
	
	
	//COSTRUTTORE:
	public Model() {
		this.corsoDAO = new CorsoDAO();
		this.studenteDAO = new StudenteDAO();
	}
	
	
	
	//METODI:
	public List<Corso> getTuttiICorsi(){
		return this.corsoDAO.getTuttiICorsi();	
	}
	
	
	public Studente getStudente(int matricola) {
		return this.studenteDAO.getStudente(matricola);
	}
}
