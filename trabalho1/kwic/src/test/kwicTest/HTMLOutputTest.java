package kwicTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import kwic.html.HTMLOutput;

public class HTMLOutputTest {

	@Test
	public void testRun() {
		HTMLOutput ho = new HTMLOutput();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(new String(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit/" + 
				"Maecenas mollis justo ac ex viverra, a lobortis elit dapibus/" + 
				"Nunc sit amet purus at mauris dictum pharetra").split("/")));
		File f = new File("kwic.html");
		f.delete();
		ho.run(list);
		assertEquals(true, f.exists());
	}

}
