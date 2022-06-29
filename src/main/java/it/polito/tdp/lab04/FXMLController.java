package it.polito.tdp.lab04;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	//ATTRIBUTO DI RIFERIMENTO AL MODEL:
	private Model model;
	
	private List<Corso> corsi;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private Button btnCercaNome;

    @FXML
    private Button btnIscriviti;

    @FXML
    private Button btnReset;

    @FXML
    private ComboBox<Corso> comboCorsi; //!!

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCercaCorsi(ActionEvent event) {

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void doCercaNome(ActionEvent event) {
    	
    	int matricola = Integer.parseInt(txtMatricola.getText()); 
    	
    	Studente studente = model.getStudente(matricola);
    	
    	txtNome.setText(studente.getNome());
    	txtCognome.setText(studente.getCognome());
 
    }

    @FXML
    void doIscriviti(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    	comboCorsi.setValue(null);
    	
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	txtResult.clear();
    }

    
    //METODO setModel():
    public void setModel(Model model) {
    	
    	//PER ASSOCIARE IL MODEL ALL'ATTRIBUTO DI RIFERIMENTO:
		this.model = model;
		
		
		//Per inizializzare il menu a tendina dei corsi:
		
		//1.ottienere tutti i corsi del model
    	corsi = model.getTuttiICorsi();
    	
    	//2.aggiungi tutti i corsi alla ComboBox
    	//Collections.sort(corsi); //eventualmente in ordine alfabetico
    	comboCorsi.getItems().addAll(corsi);
		
	}
    
    
    
    @FXML
    void initialize() {
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscriviti != null : "fx:id=\"btnIscriviti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	

}
