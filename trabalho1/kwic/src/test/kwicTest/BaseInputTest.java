package kwicTest;

import org.junit.*;
import org.junit.Assert.*;

import kwic.base.BaseInput;

public class BaseInputTest {
	
	@Test
	public void testGetLines() {
		BaseInput in = new BaseInput("input.txt");
		int size = in.getLines().size();
		
		Assert.assertEquals(54, size);
	}
	
	@Test
	public void testGetFileName() {
		String filen = "input.txt";
		BaseInput in = new BaseInput(filen);
		
		Assert.assertEquals(filen, in.getFileName());
	}

	
}
