package kwic;

import java.util.ArrayList;

import kwic.base.BaseOutput;
import kwic.dblp.DBLPInput;
import kwic.interfaces.Input;
import kwic.interfaces.Output;

public class DBLPBaseKwic extends Kwic {

	public DBLPBaseKwic() {
		super();
	}
	@Override
	Input getinput() {
		Input in = new DBLPInput();
		return in;
	}

	@Override
	Output getoutput(ArrayList<String> arr) {
		Output out = new BaseOutput(arr);
		return out;
	}

}
