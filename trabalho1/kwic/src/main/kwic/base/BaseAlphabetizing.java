package kwic.base;

import kwic.interfaces.Alphabetizing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BaseAlphabetizing implements Alphabetizing {

	private ArrayList<ArrayList<String>> shifted_words;
	private ArrayList<String> new_shifted_words;

	public BaseAlphabetizing(ArrayList<ArrayList<String>> _shifted_words) {
		this.shifted_words = _shifted_words;
		new_shifted_words = new ArrayList<String>();
	}
	
	public BaseAlphabetizing() {
		this.new_shifted_words = new ArrayList<String>();
	}

	// prepara um array para poder ser usado pelo sort
	private ArrayList<String> getNewShiftedWords() {
		this.new_shifted_words.clear();
		
		for (ArrayList<String> line : shifted_words) {
			String string_line = "";
			for (String word : line) {
				string_line = string_line.concat(word);
				string_line = string_line.concat(" ");
			}
			new_shifted_words.add(string_line);
		}

		return new_shifted_words;
	}
	
	private ArrayList<String> getNewShiftedWords(ArrayList<ArrayList<String>> shifted_words) {
		this.new_shifted_words.clear();
		
		for (ArrayList<String> line : shifted_words) {
			String string_line = "";
			for (String word : line) {
				string_line = string_line.concat(word);
				string_line = string_line.concat(" ");
			}
			new_shifted_words.add(string_line);
		}

		return new_shifted_words;
	}

	// retorna um array organizado em ordem alfabetica
	public ArrayList<String> getAlphabetizedArray() {

		ArrayList<String> temp = this.getNewShiftedWords();

		Collections.sort(temp, new Comparator<Object>() {
			@Override
			public int compare(Object a, Object b) {
				String aa = (String) a;
				String bb = (String) b;
				return aa.toLowerCase().compareTo(bb.toLowerCase());
			}
		});

		return temp;
	}
	
	public ArrayList<String> getAlphabetizedArray(ArrayList<ArrayList<String>> shifted_words) {

		ArrayList<String> temp = this.getNewShiftedWords(shifted_words);

		Collections.sort(temp, new Comparator<Object>() {
			@Override
			public int compare(Object a, Object b) {
				String aa = (String) a;
				String bb = (String) b;
				return aa.toLowerCase().compareTo(bb.toLowerCase());
			}
		});

		return temp;
	}

}
