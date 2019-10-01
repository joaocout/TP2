package kwic.base;

import java.util.ArrayList;

import kwic.interfaces.Output;

public class BaseOutput implements Output{
	
	private ArrayList<String> lines;
	
	public BaseOutput(ArrayList<String> lines) {
		this.lines = lines;
	}
	
	public void run() {
		for (String linha : this.lines) {
			System.out.println(linha.toString());
		}
	}
}
