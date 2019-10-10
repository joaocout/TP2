package kwicTest;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import kwic.base.BaseCircularShift;

public class BaseCircularShiftTest {

	@Test
	public void testGetShiftedWordsArg() {
		BaseCircularShift bcs = new BaseCircularShift();
		
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords(line);
		
		assertEquals(8, lines.size());
	}
	
	@Test
	public void testGetShiftedWordsArg1() {
		BaseCircularShift bcs = new BaseCircularShift();
		
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords(line);
		
		assertEquals(10, lines.get(0).size());
	}
	
	@Test
	public void testGetShiftedWords() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(8, lines.size());
	}
	
	@Test
	public void testGetShiftedWords1() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(0).size());
	}
	
	@Test
	public void testGetShiftedWords2() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(1).size());
	}
	
	@Test
	public void testGetShiftedWords3() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(2).size());
	}
	
	@Test
	public void testGetShiftedWords4() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(3).size());
	}
	
	@Test
	public void testGetShiftedWords5() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(4).size());
	}
	
	@Test
	public void testGetShiftedWords6() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(5).size());
	}
	
	@Test
	public void testGetShiftedWords7() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(6).size());
	}
	
	@Test
	public void testGetShiftedWords8() {
		ArrayList<String> line = new ArrayList<String>();
		line.add("Refactoring delta-oriented product lines to enforce guidelines for efficient type-checking");
		
		BaseCircularShift bcs = new BaseCircularShift(line);
		
		ArrayList<ArrayList<String>> lines = bcs.getShiftedWords();
		
		assertEquals(10, lines.get(7).size());
	}

}
