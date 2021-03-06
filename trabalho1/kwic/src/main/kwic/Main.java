package kwic;

import kwic.interfaces.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("file:Beans.xml");
		
		Input in = (Input) context.getBean("input");
		
		CircularShift cs = (CircularShift) context.getBean("circular-shift");
		
		StopWord sw = (StopWord) context.getBean("stopword");
		
		Alphabetizing al = (Alphabetizing) context.getBean("alphabetizing");
		
		Output bo = (Output) context.getBean("output");
		
		bo.run(al.getAlphabetizedArray(sw.filterLines(cs.getShiftedWords(in.getLines()))));
	}

}