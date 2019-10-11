package test;

import org.junit.*;
import epl.*;

public class mulTest {

	@Test
	public void eval1Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(15);
		Mul c = new Mul(a, b);
		
		EvalVisitor ev = new EvalVisitor();
		c.accept(ev);
		Assert.assertEquals(150, ev.eval());
	}
	
	@Test
	public void eval2Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(15);
		Mul c = new Mul(a, b);
		
		Literal aa = new Literal(7);
		Mul d = new Mul(c, aa);
		EvalVisitor ev = new EvalVisitor();
		d.accept(ev);
		Assert.assertEquals(1050, ev.eval());
	}
	
}
