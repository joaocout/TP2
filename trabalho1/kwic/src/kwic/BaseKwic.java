package kwic;

import java.util.ArrayList;

import kwic.base.BaseInput;
import kwic.base.BaseOutput;
import kwic.interfaces.Input;
import kwic.interfaces.Output;

public class BaseKwic extends Kwic {
	public BaseKwic() {
		super();
		
	}

	@Override
	Input getinput() {
		Input in = new BaseInput("input.txt");
		return in;
	}

	@Override
	Output getoutput(ArrayList<String> arr) {
		Output out = new BaseOutput(arr);
		return out;
	}
}
