package kwic.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import kwic.interfaces.StopWord;

public class BaseStopWord implements StopWord {

	ArrayList<String> swlist;
	public BaseStopWord() {
		this.swlist = new ArrayList<String>();
	}
	
	private void getFromFile() {
		try {
			FileReader file = new FileReader("stop_words.txt");
			BufferedReader buff = new BufferedReader(file);
			
			String line = buff.readLine();
			swlist.clear();
			while(line!=null) {
				swlist.add(line);
				line = buff.readLine();
			}
			buff.close();
		}
		catch (Exception e) {
			System.err.printf("Error reading stop word list");
			e.printStackTrace();
		}
	}
	
	public boolean isStopWord(String str) {
		if(this.swlist.size() == 0)
			this.getFromFile();
		return (this.swlist.contains(str.toLowerCase()));
	}
	
	public ArrayList<ArrayList<String>> filterLines(ArrayList<ArrayList<String>> shifted_lines) {
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for(ArrayList<String> l : shifted_lines) {
			if(!this.isStopWord(l.get(0)) && !l.get(0).equals("/")) { // se keyword for stop word, ignora
				res.add(new ArrayList<String>(l));
			}
		}
		return res;
	}
}
