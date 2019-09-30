package kwic.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import kwic.interfaces.StopWord;

public class BaseStopWord implements StopWord {

	ArrayList<String> swlist;
	public BaseStopWord() {
		this.swlist = new ArrayList<String>();
		try {
			FileReader file = new FileReader("stop_words.txt");
			BufferedReader buff = new BufferedReader(file);
			
			String line = buff.readLine();
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
	
	public ArrayList<String> getNoSWLine(ArrayList<String> line) {
		ArrayList<String> ret = new ArrayList<String>();
		for(String l : line) {
			if(!swlist.contains(l))
				ret.add(l);
		}
		
		return ret;
	}
	
	public boolean isStopWord(String str) {
		return this.swlist.contains(str);
	}
}
