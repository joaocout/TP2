package test;

import epl.*;
import org.junit.*;

public class subTest {

	@Test
	public void eval1Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(15);
		Sub c = new Sub(a, b);
		
		EvalVisitor ev = new EvalVisitor();
		c.accept(ev);
		Assert.assertEquals(-5, ev.eval());
	}
	
	@Test
	public void eval2Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(15);
		Sub c = new Sub(a, b);
		
		Literal aa = new Literal(7);
		Sub d = new Sub(c, aa);
		EvalVisitor ev = new EvalVisitor();
		d.accept(ev);
		Assert.assertEquals(-12, ev.eval());
	}
	
	
}
