package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {

	//ATTRIBUTI:
	private CorsoDAO corsoDAO; 
	
	
	
	//COSTRUTTORE:
	public Model() {
		this.corsoDAO = new CorsoDAO();
	}
	
	
	
	//METODI:
	public List<Corso> getTuttiICorsi(){
		return this.corsoDAO.getTuttiICorsi();	
	}
}
