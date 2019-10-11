package epl.interfaces;

import epl.*;

public interface Visitor {
	
	void visit(Add a);
	void visit(Literal l);
	void visit(Sub s);
	void visit(Mul m);
	void visit(Div d);

}
