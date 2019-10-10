package kwic;

import java.util.Scanner;

import kwic.base.*;
import kwic.interfaces.*;
import kwic.dblp.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("file:Beans.xml");
		Input in = (Input) context.getBean("input");

		
			
		//Input in = new DBLPInput();
		//Input in = new BaseInput("input.txt");
		CircularShift cs = new BaseCircularShift(in.getLines());
		Alphabetizing al = new BaseAlphabetizing(cs.getShiftedWords());
		Output bo = new BaseOutput(al.getAlphabetizedArray());
		bo.run();
	}

}