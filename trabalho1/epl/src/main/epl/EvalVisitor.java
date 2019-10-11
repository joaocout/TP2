package epl;

import epl.interfaces.*;


public class EvalVisitor implements Visitor {
	
	private int val;
	
	@Override
	public void visit(Add a) {
		val = visitEval(a);
	}
	
	@Override
	public void visit(Sub s) {
		val = visitEval(s);
	}
	
	@Override
	public void visit(Mul m) {
		val = visitEval(m);
	}
	
	@Override
	public void visit(Literal l) {
		val = visitEval(l);
	}
	
	@Override
	public void visit(Div d) {
		val = visitEval(d);
	}
	
	//para cada nova operacao adicionada, eh necessario a adicao de um novo caso
	private int visitEval(Expression e) {
		
		if(e instanceof Literal){
			Literal l = (Literal)e;
			return l.getVal();
		}
		else if(e instanceof Add) {
			Add a = (Add)e;
			return visitEval(a.getLeft()) + visitEval(a.getRight());
		}
		else if(e instanceof Sub) {
			Sub s = (Sub)e;
			return visitEval(s.getLeft()) - visitEval(s.getRight());
		}
		
		else if(e instanceof Mul) {
			Mul m = (Mul)e;
			return visitEval(m.getLeft()) * visitEval(m.getRight());
		}
		
		else if(e instanceof Div) {
			Div d = (Div)e;
			return visitEval(d.getLeft()) / visitEval(d.getRight());
		}
		
		else return 0;
		
	}
	
	public int eval() {
		return val;
	}
	
	
}
