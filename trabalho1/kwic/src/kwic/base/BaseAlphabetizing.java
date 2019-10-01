package kwic.base;

import kwic.interfaces.Alphabetizing;
import java.util.ArrayList;
import java.util.Collections;

public class BaseAlphabetizing implements Alphabetizing {
	
	private ArrayList<ArrayList<String>> shifted_words;
	private ArrayList<String> new_shifted_words;
	
	public BaseAlphabetizing(ArrayList<ArrayList<String>> _shifted_words) {
		this.shifted_words = _shifted_words;
		new_shifted_words = new ArrayList<String>();
	}
	
	//prepara um array para poder ser usado pelo sort
	private ArrayList<String> getNewShiftedWords(){
		
		for(ArrayList<String> line : shifted_words) {
			String string_line = "";
			for(String word : line) {
				string_line = string_line.concat(word);
				string_line = string_line.concat(" ");
			}
			new_shifted_words.add(string_line);
		}
		
		return new_shifted_words;
	}
	
	//retorna um array organizado em ordem alfabetica
	public ArrayList<String> getAlphabetizedArray() {
		
		ArrayList<String> temp = this.getNewShiftedWords();
		
		Collections.sort(temp);
		
		return temp;
		
	}

}
