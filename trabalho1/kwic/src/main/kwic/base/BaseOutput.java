package kwic.base;

import java.util.ArrayList;

import kwic.interfaces.Output;

public class BaseOutput implements Output{
	
	public BaseOutput() { }
	
	public void run(ArrayList<String> lines) {
		for (String linha : lines) {
			System.out.println(linha.toString());
		}
	}
}
