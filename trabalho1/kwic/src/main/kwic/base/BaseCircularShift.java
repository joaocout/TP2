package kwic.base;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kwic.interfaces.CircularShift;
import kwic.interfaces.StopWord;

public class BaseCircularShift implements CircularShift {

	private ArrayList<String> lines;
	//lista de listas, separando cada palavra de cada linha
	// lista de listas, separando cada palavra de cada linha
	private ArrayList<ArrayList<String>> words;
	private ArrayList<ArrayList<String>> shifted_words;

	public BaseCircularShift(ArrayList<String> _lines) {
		this.shifted_words = new ArrayList<ArrayList<String>>();
		this.words = new ArrayList<ArrayList<String>>();
		this.lines = _lines;
	}
	
	public BaseCircularShift() {
		this.shifted_words = new ArrayList<ArrayList<String>>();
		this.words = new ArrayList<ArrayList<String>>();
	}

	// retorna uma matriz com todas as palavras do texto
	private ArrayList<ArrayList<String>> getWords() {
		this.words.clear();
		for (String line : lines) {
			ArrayList<String> temp = new ArrayList<String>(Arrays.asList(line.split(" ")));
			words.add(temp);
		}

		return words;
	}
	
	// retorna uma matriz com todas as palavras do texto
	private ArrayList<ArrayList<String>> getWords(ArrayList<String> lines) {
		this.words.clear();
		for (String line : lines) {
			ArrayList<String> temp = new ArrayList<String>(Arrays.asList(line.split(" ")));
			words.add(temp);
		}

		return words;
	}

	// retorna uma lista, com todos os circular shifts possiveis, armazenados em
	// listas
	public ArrayList<ArrayList<String>> getShiftedWords(){
		ArrayList<ArrayList<String>> temp = this.getWords();
		this.shifted_words.clear();

		for (ArrayList<String> line : temp) {
			ArrayList<String> origline = new ArrayList<String>(line);
			//origline.remove(origline.size()-1);
			shifted_words.add(origline);
			int size = line.size() - 1;
			for (int i = 0; i < size; i++) {
				String aux = line.get(0);
				line.remove(0);
				line.add(aux);
				@SuppressWarnings("resource")
				ApplicationContext context = new ClassPathXmlApplicationContext("file:Beans.xml");
				StopWord sw = (StopWord) context.getBean("stopword");
				if (!(sw.isStopWord(line.get(0))) && !line.get(0).equals("/")) {
					shifted_words.add(new ArrayList<String>(line));
				}
			}

		}
		
		return this.shifted_words;
	}
	
	public ArrayList<ArrayList<String>> getShiftedWords(ArrayList<String> lines) {
		ArrayList<ArrayList<String>> temp = this.getWords(lines);

		this.shifted_words.clear();
		for (ArrayList<String> line : temp) {
			ArrayList<String> origline = new ArrayList<String>(line);
			//origline.remove(origline.size()-1);
			shifted_words.add(origline);
			int size = line.size() - 1;
			for (int i = 0; i < size; i++) {
				String aux = line.get(0);
				line.remove(0);
				line.add(aux);
				@SuppressWarnings("resource")
				ApplicationContext context = new ClassPathXmlApplicationContext("file:Beans.xml");
				StopWord sw = (StopWord) context.getBean("stopword");
				if (!(sw.isStopWord(line.get(0))) && !line.get(0).equals("/")) {
					shifted_words.add(new ArrayList<String>(line));
				}
			}

		}
		
		return this.shifted_words;
	}
}
