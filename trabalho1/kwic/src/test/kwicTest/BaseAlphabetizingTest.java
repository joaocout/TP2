package kwicTest;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import kwic.base.BaseAlphabetizing;

public class BaseAlphabetizingTest {

	@Test
	public void testGetAlphabetizedArray() {
		BaseAlphabetizing ba = new BaseAlphabetizing();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray(lines);
		assertEquals(3, alph_lines.size());
	}
	
	@Test
	public void testGetAlphabetizedArrayArg() {
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));

		BaseAlphabetizing ba = new BaseAlphabetizing(lines);
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray();
		assertEquals(3, alph_lines.size());
	}
	
	@Test
	public void testGetAlphabetizedArray1() {
		BaseAlphabetizing ba = new BaseAlphabetizing();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray(lines);
		assertEquals("Sed volutpat purus vel erat porttitor luctus", alph_lines.get(1).trim());
	}
	
	@Test
	public void testGetAlphabetizedArray1Arg() {
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));

		BaseAlphabetizing ba = new BaseAlphabetizing(lines);
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray();
		assertEquals("Sed volutpat purus vel erat porttitor luctus", alph_lines.get(1).trim());
	}
	
	@Test
	public void testGetAlphabetizedArray2() {
		BaseAlphabetizing ba = new BaseAlphabetizing();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray(lines);
		assertEquals("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus", alph_lines.get(2).trim());
	}
	
	@Test
	public void testGetAlphabetizedArray2Arg() {
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));

		BaseAlphabetizing ba = new BaseAlphabetizing(lines);
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray();
		assertEquals("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus", alph_lines.get(2).trim());
	}
	
	@Test
	public void testGetAlphabetizedArray3() {
		BaseAlphabetizing ba = new BaseAlphabetizing();
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray(lines);
		assertEquals("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare", alph_lines.get(0).trim());
	}
	
	@Test
	public void testGetAlphabetizedArray3Arg() {
		ArrayList<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
		lines.add(new ArrayList<String>(Arrays.asList(new String("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Ut malesuada massa quis tellus porttitor, non lacinia enim faucibus").split(" "))));
		lines.add(new ArrayList<String>(Arrays.asList(new String("Sed volutpat purus vel erat porttitor luctus").split(" "))));

		BaseAlphabetizing ba = new BaseAlphabetizing(lines);
		
		ArrayList<String> alph_lines = ba.getAlphabetizedArray();
		assertEquals("Donec finibus urna sit amet arcu consectetur, sed gravida erat ornare", alph_lines.get(0).trim());
	}

}
