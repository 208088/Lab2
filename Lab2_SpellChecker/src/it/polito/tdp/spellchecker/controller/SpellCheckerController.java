package it.polito.tdp.spellchecker.controller;


import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdt.spellchecker.model.*;
import it.polito.tdt.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class SpellCheckerController {
	
	Dictionary d;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> btnlanguage;

    @FXML
    private TextArea txttesto;

    @FXML
    private Button check;

    @FXML
    private TextFlow txtcorretto;

    @FXML
    private Label lblerr;

    @FXML
    private Button btnclear;

    @FXML
    private Label lblcompletamento;

    @FXML
    void doCheck(ActionEvent event) {
    	if(btnlanguage.getValue().compareTo("English")==0)
    		d=new EnglishDictionary();
    	else d= new ItalianDictionary();
    	d.loadDictionary();
    	int err=0;
    	long time=System.nanoTime();
    	List<RichWord> lista = d.spellCheckText(d.getListSpell(txttesto.getText()));
    	long time1= System.nanoTime(); 
    	
    	for (RichWord r : lista) {
    		Text z= new Text(r.getParola()+ " ");
			if(!r.isCorretta()) {
				z.setFill(Color.RED);
			
				err++;
		     }  
			else z.setFill(Color.BLACK);
				
    	txtcorretto.getChildren().add(z);
    }
    	  
    	txtcorretto.setVisible(true);
    	lblerr.setText(String.format("Numero di errori: %d", err));
	String c= String.valueOf((double)((time1-time)/1000000000));
    lblcompletamento.setText("Spell check completed in :"+ c+"s");
    }

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doLanguage(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert btnlanguage != null : "fx:id=\"btnlanguage\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txttesto != null : "fx:id=\"txttesto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert txtcorretto != null : "fx:id=\"txtcorretto\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblerr != null : "fx:id=\"lblerr\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnclear != null : "fx:id=\"btnclear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblcompletamento != null : "fx:id=\"lblcompletamento\" was not injected: check your FXML file 'SpellChecker.fxml'.";

        btnlanguage.getItems().addAll("English", "Italiano");
    }
}

