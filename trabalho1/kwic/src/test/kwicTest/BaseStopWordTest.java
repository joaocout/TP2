package kwicTest;

import org.junit.*;

import kwic.base.BaseStopWord;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseStopWordTest {

	@Test
	public void testGetLine() {
		BaseStopWord bs = new BaseStopWord();
		ArrayList<String> line = new ArrayList<String>(Arrays.asList(new String("Refactoring delta-oriented product lines to "
				+ "enforce guidelines for efficient type-checking").split(" ")));
		
		ArrayList<String> swline = new ArrayList<String>(Arrays.asList(new String("Refactoring delta-oriented product lines "
				+ "enforce guidelines efficient type-checking").split(" ")));
		
		Assert.assertEquals(swline, bs.getLine(line));
	}

}
