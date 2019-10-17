package kwic.interfaces;

import java.util.ArrayList;

public interface StopWord {
	public boolean isStopWord(String str);
	public ArrayList<ArrayList<String>> filterLines(ArrayList<ArrayList<String>> shifted_words); 
}
