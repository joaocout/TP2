package epl;

import epl.interfaces.Expression;

public class Literal implements Expression {
	
	int val;
	
	public Literal(int val) {
		this.val = val;
	}
	
	@Override
	public void print() {
		System.out.print(this.val);
	}

}
