package epl;

import epl.interfaces.*;

public class Add implements Expression, Visitable{
	
	private Expression left, right;
	
	public Add(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public Expression getLeft() {
		return left;
	}
	
	public Expression getRight() {
		return right;
	}

}
