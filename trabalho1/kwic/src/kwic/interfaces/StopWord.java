package kwic.interfaces;

import java.util.ArrayList;

public interface StopWord {
	public ArrayList<String> getNoSWLine(ArrayList<String> line);
	public boolean isStopWord(String str);
}
