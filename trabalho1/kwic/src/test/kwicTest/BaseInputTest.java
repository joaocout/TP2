package kwicTest;

import static org.junit.Assert.*;
import org.junit.*;
import kwic.base.BaseInput;

public class BaseInputTest {
	
	@Test
	public void testGetLines() {
		BaseInput in = new BaseInput("input.txt");
		int size = in.getLines().size();
		
		assertEquals(54, size);
	}
	
	@Test
	public void testGetFileName() {
		String filen = "input.txt";
		BaseInput in = new BaseInput(filen);
		
		assertEquals(filen, in.getFileName());
	}

	
}
