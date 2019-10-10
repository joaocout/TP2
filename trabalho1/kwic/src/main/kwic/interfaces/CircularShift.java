package kwic.interfaces;

import java.util.ArrayList;

public interface CircularShift {
	public ArrayList<ArrayList<String>> getShiftedWords();
	public ArrayList<ArrayList<String>> getShiftedWords(ArrayList<String> lines);
}
