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
	
	public ArrayList<String> getLine(ArrayList<String> line) {
		this.getFromFile();
		ArrayList<String> ret = new ArrayList<String>();
		for(String l : line) {
			if(!this.isStopWord(l))
				ret.add(l);
		}
		
		return ret;
	}
	
	public ArrayList<ArrayList<String>> getAllLines(ArrayList<ArrayList<String>> lines) {
		this.getFromFile();
		ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		for(ArrayList<String> l1 : lines) {
			res.add(this.getLine(l1));
		}
		return res;
	}
	
	public boolean isStopWord(String str) {
		return (this.swlist.contains(str.toLowerCase()));
	}
}
