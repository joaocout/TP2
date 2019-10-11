package test;

import epl.*;
import org.junit.*;


//o metodo eval utiliza quase tds os metodos da classe
public class addTest {
	
	@Test
	public void eval1Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(15);
		Add c = new Add(a, b);
		
		EvalVisitor ev = new EvalVisitor();
		c.accept(ev);
		Assert.assertEquals(25, ev.eval());
	}
	
	@Test
	public void eval2Test() {
		
		Literal a = new Literal(10);
		Literal b = new Literal(15);
		Add c = new Add(a, b);
		
		Literal aa = new Literal(7);
		Add d = new Add(c, aa);
		EvalVisitor ev = new EvalVisitor();
		d.accept(ev);
		Assert.assertEquals(32, ev.eval());
	}
	
}
