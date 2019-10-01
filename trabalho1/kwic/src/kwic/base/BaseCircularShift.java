package kwic.base;

import java.util.ArrayList;
import kwic.interfaces.CircularShift;

public class BaseCircularShift implements CircularShift {

	// lista de listas, separando cada palavra de cada linha
	private ArrayList<ArrayList<String>> words;
	private ArrayList<ArrayList<String>> shifted_words;

	public BaseCircularShift(ArrayList<ArrayList<String>> _lines) {
		this.shifted_words = new ArrayList<ArrayList<String>>();
		this.words = new ArrayList<ArrayList<String>>(_lines);
	}

	// retorna uma lista, com todos os circular shifts possiveis,
	// com as palavras armazenadas em listas
	public ArrayList<ArrayList<String>> getShiftedWords() {
		for (ArrayList<String> line : this.words) {
			shifted_words.add(new ArrayList<String>(line));
			int size = line.size() - 1;
			for (int i = 0; i < size; i++) {
				String aux = line.get(0);
				line.remove(0);
				line.add(aux);
				shifted_words.add(new ArrayList<String>(line));
			}

		}
		return shifted_words;
	}
}
