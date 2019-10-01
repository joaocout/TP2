package kwic;

import kwic.base.*;
import kwic.interfaces.*;
import kwic.dblp.*;

public class Main {

	public static void main(String[] args) {
		Input in = new BaseInput("input.txt");
		//Input in = new DBLPInput();

		StopWord bs = new BaseStopWord();

		CircularShift cs = new BaseCircularShift(bs.getAllLines(in.getLines()));

		Alphabetizing al = new BaseAlphabetizing(cs.getShiftedWords());
		/*
		for (String linha : al.getAlphabetizedArray()) {
			System.out.println(linha.toString());
		}*/
		
		Output bo = new BaseOutput(al.getAlphabetizedArray());
		bo.run();
		
		
		/**
		 * FAZER FACTORY PRA CRIAR ISSO TUDO COM BASE/DBLP/OUTPUT CUSTOM
		 * 
		 */
	}

}
