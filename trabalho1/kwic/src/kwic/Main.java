package kwic;


import java.util.ArrayList;

public class Main {

	
	public static void main(String[] args) {
		
		Input in = new Input("input.txt");
		System.out.println(in.getLines());
		
		
		
		CircularShift cs = new CircularShift(in.getLines());
		
		ArrayList<ArrayList<String>> a = cs.getShiftedWords();
		for(ArrayList<String> array : a) {
			System.out.println(array);
		}
		
		
	}
	
	
}
