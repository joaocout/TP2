package epl;

import epl.interfaces.Expression;

public class Add implements Expression {
	
	Expression left;
	Expression right;
	
	public Add(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void print() {
		System.out.print("(");
		this.left.print();
		System.out.print(" + ");
		this.right.print();
		System.out.print(")");
	}

}
