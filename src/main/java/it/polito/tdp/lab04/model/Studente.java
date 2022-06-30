package it.polito.tdp.lab04.model;

import java.util.Objects;

public class Studente {
	
	//ATTRIBUTI:
	private int matricola;
	private String nome; 
	private String cognome;
	
	
	
	//COSTRUTTORE:
	public Studente(int matricola, String nome, String cognome) {
	
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}



	//METODI DI DEFAULT:
	
	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(matricola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		return matricola == other.matricola;
	}


	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + "]";
	} 
	
	
	
}
