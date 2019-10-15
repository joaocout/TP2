package epl;

import epl.interfaces.*;

public class Literal implements Expression,Visitable {
	
	private int val;
	
	public Literal(int val) {
		this.val = val;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public int getVal() {
		return val;
	}

}
