package it.polito.tdt.spellchecker.model;

import java.io.*;
import java.util.*;


public class EnglishDictionary extends Dictionary {

	private List<String> lista= new ArrayList<String>();

	
	public void loadDictionary() {
		try{
			BufferedReader br= new BufferedReader(new FileReader("rsc/English.txt"));
			String word;
			while ((word = br.readLine()) != null) {
			// Aggiungere word alla struttura dati
				lista.add(word);
			}
			br.close();
			} catch (IOException e){
			System. out.println("Errore nella lettura del file");
			}
	}
	
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList) {
		boolean esiste=false;
		List<RichWord> elenco= new ArrayList<RichWord>();
		for (String s : inputTextList) {
			 esiste=false;
				int i=0;
				int f=lista.size();
				int m=(int)((f+i)/2);
				while (i!=f && !esiste && i<f){
					if ( s.compareToIgnoreCase(lista.get(m))==0){ esiste=true;}
					else if(s.compareToIgnoreCase(lista.get(m))<0){ f=m;}
					else {i=m;}
					m=(int) ((f+i)/2);
					if(f==i+1){ if (s.compareToIgnoreCase(lista.get(i))==0) {esiste=true;}
					else if (s.compareToIgnoreCase(lista.get(f))==0) { esiste=true;}
					else break;}
				}
				
				elenco.add(new RichWord(s, esiste));
			
			
		} return elenco;
	}		


}
