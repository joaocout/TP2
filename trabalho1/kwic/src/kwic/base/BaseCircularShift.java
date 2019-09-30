package kwic.base;

import java.util.ArrayList;
import java.util.Arrays;
import kwic.interfaces.CircularShift;

public class BaseCircularShift implements CircularShift {
		
		private ArrayList<String> lines;
		// lista de listas, separando cada palavra de cada linha
		private ArrayList<ArrayList<String>> words;
		private ArrayList<ArrayList<String>> shifted_words;
		
		public BaseCircularShift(ArrayList<String> _lines) {
			shifted_words = new ArrayList<ArrayList<String>>();
			words = new ArrayList<ArrayList<String>>();
			this.lines = _lines;
		}
		
		// retorna uma matriz com todas as palavras do texto
		private ArrayList<ArrayList<String>> getWords(){
			
			for(String line : lines) {
				ArrayList<String> temp = new ArrayList<String>(Arrays.asList(line.split(" ")));
				words.add(temp);
			}
			
			return words;
		}
		
		// retorna uma lista, com todos os circular shifts possiveis, armazenados em listas
		public ArrayList<ArrayList<String>> getShiftedWords(){
			
			ArrayList<ArrayList<String>> temp = this.getWords();
			
			for(ArrayList<String> line : temp) {
				shifted_words.add(new ArrayList<String>(line));
				int size = line.size() - 1;
				for(int i=0; i<size; i++) {
					String aux  = line.get(0);
					line.remove(0);
					line.add(aux);
					if(!(new BaseStopWord().isStopWord(line.get(0)))) {
						shifted_words.add(new ArrayList<String>(line));
					}
				}
				
			}
			
			return shifted_words;
		}
		
}
