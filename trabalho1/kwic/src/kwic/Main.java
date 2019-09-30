package kwic;


import java.util.ArrayList;

import kwic.base.BaseCircularShift;
import kwic.base.BaseInput;
import kwic.interfaces.*;

public class Main {

	
	public static void main(String[] args) {
		
		Input in = new BaseInput("input.txt");
	
		CircularShift cs = new BaseCircularShift(in.getLines());
		ArrayList<ArrayList<String>> a = cs.getShiftedWords();
		for(ArrayList<String> array : a) {
			System.out.println(array);
		}
		
		
	}
	
	
}
