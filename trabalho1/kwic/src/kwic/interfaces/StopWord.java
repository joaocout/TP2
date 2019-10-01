package kwic.interfaces;

import java.util.ArrayList;

public interface StopWord {
	public ArrayList<ArrayList<String>> getAllLines(ArrayList<ArrayList<String>> lines);
	public ArrayList<String> getLine(ArrayList<String> line);
	public boolean isStopWord(String str);
}
