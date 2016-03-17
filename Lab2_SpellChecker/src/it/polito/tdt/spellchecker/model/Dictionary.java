package it.polito.tdt.spellchecker.model;

import java.util.*;

//ruolo di MODEL

public class Dictionary {
	
	
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		return null;
	}


	public void loadDictionary() {
		// TODO Auto-generated method stub
	} 

	public List<String> getListSpell(String frase){
		List<String> lista=new ArrayList<String>();
		StringTokenizer st= new StringTokenizer(frase, " ");
		while(st.hasMoreTokens()){
			String word=st.nextToken();
			word=word.toLowerCase();
			int i=word.length()-1;
			if(!Character.isLetter(word.charAt(i))){
				word=word.substring(0, i);
			}
			lista.add(word);
		}
		return lista;
	}
}
