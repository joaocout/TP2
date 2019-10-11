package test;

import org.junit.*;
import epl.*;

public class divTest {

	@Test
	public void eval1Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(2);
		Div c = new Div(a, b);
		
		EvalVisitor ev = new EvalVisitor();
		c.accept(ev);
		Assert.assertEquals(5, ev.eval());
	}
	
	@Test
	public void eval2Test() {
		
		Literal a = new Literal(42);
		Literal b = new Literal(6);
		Add c = new Add(a, b);
		
		Literal aa = new Literal(7);
		Add d = new Add(c, aa);
		EvalVisitor ev = new EvalVisitor();
		d.accept(ev);
		Assert.assertEquals(1, ev.eval());
	}
	
}
