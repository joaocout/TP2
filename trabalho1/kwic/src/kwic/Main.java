package kwic;

import kwic.base.*;
import kwic.interfaces.*;
import kwic.dblp.*;

public class Main {

	public static void main(String[] args) {
		/*
		Input in = new BaseInput("input.txt");
		//Input in = new DBLPInput();

		CircularShift cs = new BaseCircularShift(in.getLines());

		Alphabetizing al = new BaseAlphabetizing(cs.getShiftedWords());

		Output bo = new BaseOutput(al.getAlphabetizedArray());
		bo.run();		
		
		/**
		 * FAZER FACTORY PRA CRIAR ISSO TUDO COM BASE/DBLP/OUTPUT CUSTOM
		 * 
		 */
		int mode = 2;
		new KwicFactory(mode);
	}

}
