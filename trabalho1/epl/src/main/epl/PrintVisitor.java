package epl;

import epl.interfaces.*;


public class PrintVisitor implements Visitor {
	
	private String p;
	
	@Override
	public void visit(Add a) {
		p = visitPrint(a);
	}
	
	@Override
	public void visit(Sub s) {
		p = visitPrint(s);
	}
	
	@Override
	public void visit(Mul m) {
		p = visitPrint(m);
	}
	
	@Override
	public void visit(Literal l) {
		p = visitPrint(l);
	}
	
	@Override
	public void visit(Div d) {
		p = visitPrint(d);
	}
	
	//para cada nova operacao adicionada, eh necessario a adicao de um novo caso
	private String visitPrint(Expression e) {
		
		if(e instanceof Literal){
			Literal l = (Literal)e;
			return Integer.toString(l.getVal());
		}
		else if(e instanceof Add) {
			Add a = (Add)e;
			return "(" + visitPrint(a.getLeft()) + " + " + visitPrint(a.getRight()) + ")";
		}
		else if(e instanceof Sub) {
			Sub s = (Sub)e;
			return "(" + visitPrint(s.getLeft()) + " - " + visitPrint(s.getRight()) + ")";
		}
		
		else if(e instanceof Mul) {
			Mul m = (Mul)e;
			return "(" + visitPrint(m.getLeft()) + " * " + visitPrint(m.getRight()) + ")";
		}
		
		else if(e instanceof Div) {
			Div d = (Div)e;
			return "(" + visitPrint(d.getLeft()) + " / " + visitPrint(d.getRight()) + ")";
		}
		
		else return "";
		
	}
	
	public int print() {
		System.out.print(p);
	}
	
	
}
