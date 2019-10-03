package kwic;

import java.util.ArrayList;

import kwic.base.BaseAlphabetizing;
import kwic.base.BaseCircularShift;
import kwic.interfaces.Alphabetizing;
import kwic.interfaces.CircularShift;
import kwic.interfaces.Input;
import kwic.interfaces.Output;

public abstract class Kwic {
	
	public Kwic() {
		Input in = getinput();
		CircularShift cs = new BaseCircularShift(in.getLines());
		Alphabetizing al = new BaseAlphabetizing(cs.getShiftedWords());
		Output bo = getoutput(al.getAlphabetizedArray());
		bo.run();
	}
	
	public abstract Input getinput();
	public abstract Output getoutput(ArrayList<String> arr);
	
}
