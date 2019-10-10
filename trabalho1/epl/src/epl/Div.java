package epl;

import epl.interfaces.*;

public class Div implements Expression, Visitable{

private Expression left, right;
	
	public Div(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void print() {
		System.out.print("(");
		this.left.print();
		System.out.print(" / ");
		this.right.print();
		System.out.print(")");
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
