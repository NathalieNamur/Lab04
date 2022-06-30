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
    private Button btnCerca;
    
    @FXML
    private Button btnCercaCorsiStudente;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private Button btnCompletamentoAutomatico;

    @FXML
    private Button btnIscriviti;

    @FXML
    private Button btnReset;

    @FXML
    private ComboBox<Corso> comboCorsi; //!!
    
    //NB:
    //Non dimenticare di specificare il tipo 
    //degli elementi della ComboBox.

    @FXML
    private TextField txtCognome;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextField txtNome;

    @FXML
    private TextArea txtResult;

    
    //Punto5:
    @FXML
    void doCerca(ActionEvent event) {
    	
    	txtResult.clear();
 
    	
    	try {
    		
    		int matricola = Integer.parseInt(txtMatricola.getText());
    		Studente studente = model.getStudente(matricola);
        	
    		Corso corso = comboCorsi.getValue();
    		
    		if (studente == null) {
				txtResult.appendText("Nessun risultato: matricola inesistente.");
				return; //!!
			}
    		
    		if(corso == null) {
    			txtResult.setText("Selezionare un corso.");
    			return; //!!
    		}
    		
    		//NB:
        	//Il return è indispensabile, 
    		//altrimenti l'errore non si stampa correttamente.
    		
    		
    		boolean result = model.isStudenteIscrittoACorso(matricola, corso);
    	
    		if(result == true)
    			txtResult.setText("Lo studente:\n"+model.getStudente(matricola)+"\nè iscritto al corso di "+corso+".");
    		else
    			txtResult.setText("Lo studente:\n"+model.getStudente(matricola)+"\nNON è iscritto al corso di "+corso+".");
    		
    		
    	} catch (NumberFormatException e) {
			txtResult.setText("Inserire una matricola nel formato corretto.");
		
    	} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE.");
		}
    		
    }
    
    
    //Punto4:
    @FXML
    void doCercaCorsiStudente(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	
    	try {
    		
    		int matricola = Integer.parseInt(txtMatricola.getText());
    		Studente studente = model.getStudente(matricola);
    	
    		if (studente == null){ 
    			txtResult.setText("Nessun risultato: matricola inesistente");
    			return; //!!
    		}
    	
    		//NB:
    		//Il return è indispensabile, 
    		//altrimenti l'errore non si stampa correttamente.
    	
    	
    		List<Corso> corsiByStudente = model.getCorsiByStudente(matricola);
    	
    		String elenco = "";
    	
    		for(Corso c : corsiByStudente) 
    			elenco += c + "\n";
    	
    	
    		txtResult.setText(elenco);
    		
    		
    	} catch (NumberFormatException e) {
			txtResult.setText("Inserire una matricola nel formato corretto.");
		
    	} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE.");
		}
    	
    }

    
    //Punto3:
    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	
    	txtResult.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	
    	
    	try {
    		
    		Corso corso = comboCorsi.getValue();
    	
    		if(corso == null) {
    			txtResult.setText("Selezionare un corso.");
    			return; //!!
    		}
    	
    		//NB:
        	//Il return è indispensabile, 
    		//altrimenti l'errore non si stampa correttamente.
    		
    		
    		List<Studente> studentiByCorso = model.getStudentibyCorso(corso);
    	
    		String elenco = "";
    	
    		for(Studente s : studentiByCorso) 
    			elenco += s + "\n";
    		    	
    		txtResult.setText(elenco);
    		
    		
    	} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE.");
		}
    
    }

    
    //Punto2:
    @FXML
    void doCompletamentoAutomatico(ActionEvent event) {
    	
    	txtResult.clear();
		txtNome.clear();
		txtCognome.clear();
		
		
    	try {
    		
    		int matricola = Integer.parseInt(txtMatricola.getText()); 
    		Studente studente = model.getStudente(matricola);
    	
    		if (studente == null) {
				txtResult.appendText("Nessun risultato: matricola inesistente.");
				return;
			}
    		
    		txtNome.setText(studente.getNome());
    		txtCognome.setText(studente.getCognome());
    	
    		
    	} catch (NumberFormatException e) {
			txtResult.setText("Inserire una matricola nel formato corretto.");
		
    	} catch (RuntimeException e) {
			txtResult.setText("ERRORE DI CONNESSIONE AL DATABASE.");
		}
 
    }

    /**Punto6:*/
    @FXML
    void doIscriviti(ActionEvent event) {

    }

    //Punto1:
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
		
		
		//PER INIZIALIZZARE il menu a tendina dei corsi:
		
		//1.ottienere tutti i corsi del model
    	corsi = model.getTuttiICorsi();
    	
    	//2.aggiungi tutti i corsi alla ComboBox
    	//Collections.sort(corsi); //eventualmente in ordine alfabetico
    	comboCorsi.getItems().addAll(corsi);
		
	}
    
    
    
    @FXML
    void initialize() {
        assert btnCercaCorsiStudente != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCompletamentoAutomatico != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscriviti != null : "fx:id=\"btnIscriviti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	

}
