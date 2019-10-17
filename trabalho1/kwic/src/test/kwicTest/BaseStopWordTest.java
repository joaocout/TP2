package kwicTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

import kwic.base.BaseStopWord;

public class BaseStopWordTest {

	@Test
	public void testFilterLines() {
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Refinement-based testing of delta-oriented product lines").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("testing of delta-oriented product lines / Refinement-based").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("of delta-oriented product lines / Refinement-based testing").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("delta-oriented product lines / Refinement-based testing of").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("product lines / Refinement-based testing of delta-oriented").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("lines / Refinement-based testing of delta-oriented product").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("/ Refinement-based testing of delta-oriented product lines").split(" "))));

		BaseStopWord bs = new BaseStopWord();

		assertEquals(5, bs.filterLines(lines).size());
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
