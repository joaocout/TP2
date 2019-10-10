package kwicTest;

import org.junit.*;
import kwic.base.BaseStopWord;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseStopWordTest {

	@Test
	public void testGetLineSize() {
		BaseStopWord bs = new BaseStopWord();
		ArrayList<String> line = new ArrayList<String>(Arrays.asList(new String("Refactoring delta-oriented product lines to "
				+ "enforce guidelines for efficient type-checking").split(" ")));

		assertEquals(8, bs.getLine(line).size());
	}
	
	@Test
	public void testGetLine() {
		BaseStopWord bs = new BaseStopWord();
		ArrayList<String> line = new ArrayList<String>(Arrays.asList(new String("Refactoring delta-oriented product lines to "
				+ "enforce guidelines for efficient type-checking").split(" ")));
		
		ArrayList<String> swline = new ArrayList<String>(Arrays.asList(new String("Refactoring delta-oriented product lines "
				+ "enforce guidelines efficient type-checking").split(" ")));
		
		assertEquals(swline, bs.getLine(line));
	}
	
	@Test
	public void testGetAllLinesSize() {
		BaseStopWord bs = new BaseStopWord();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Delta-oriented test case prioritization for integration testing of software product lines").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Towards incremental model slicing for delta-oriented software product lines").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Row types for delta-oriented programming").split(" "))));
		
		assertEquals(3, bs.getAllLines(lines).size());
	}
	
	@Test
	public void testGetAllLines() {
		BaseStopWord bs = new BaseStopWord();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Delta-oriented test case prioritization for integration testing of software product lines").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Towards incremental model slicing for delta-oriented software product lines").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Row types for delta-oriented programming").split(" "))));
		
		ArrayList<ArrayList<String>> swlines = new ArrayList<ArrayList<String>>();
		swlines.add(new ArrayList<String>(Arrays.asList(new String("Delta-oriented test case prioritization integration testing software product lines").split(" "))));
		swlines.add(new ArrayList<String>(Arrays.asList(new String("Towards incremental model slicing delta-oriented software product lines").split(" "))));
		swlines.add(new ArrayList<String>(Arrays.asList(new String("Row types delta-oriented programming").split(" "))));
		
		assertEquals(swlines, bs.getAllLines(lines));
	}
	
	@Test
	public void testIsStopWord() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("Those"));
	}
	
	@Test
	public void testIsStopWord1() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("those"));
	}
	
	@Test
	public void testIsStopWord2() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("They"));
	}
	
	@Test
	public void testIsStopWord3() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("they"));
	}
	
	@Test
	public void testIsStopWord4() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("I"));
	}
	
	@Test
	public void testIsStopWord5() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("i"));
	}
	
	@Test
	public void testIsStopWord6() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("Very"));
	}
	
	@Test
	public void testIsStopWord7() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("very"));
	}
	
	@Test
	public void testIsStopWord8() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("who's"));
	}
	
	@Test
	public void testIsStopWord9() {
		BaseStopWord bs = new BaseStopWord();
		assertEquals(true, bs.isStopWord("WHO'S"));
	}
	

}
