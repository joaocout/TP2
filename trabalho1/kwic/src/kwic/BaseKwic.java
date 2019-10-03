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
	public Input getinput() {
		Input in = new BaseInput("input.txt");
		return in;
	}

	@Override
	public Output getoutput(ArrayList<String> arr) {
		Output out = new BaseOutput(arr);
		return out;
	}
}
