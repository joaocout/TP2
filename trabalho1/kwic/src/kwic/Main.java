package kwic;

import java.util.Scanner;

import kwic.base.*;
import kwic.interfaces.*;
import kwic.dblp.*;

public class Main {

	public static void main(String[] args) {
		//Input in = new DBLPInput();
		Input in = new BaseInput("input.txt");
		CircularShift cs = new BaseCircularShift(in.getLines());
		Alphabetizing al = new BaseAlphabetizing(cs.getShiftedWords());
		Output bo = new BaseOutput(al.getAlphabetizedArray());
		bo.run();
	}

}