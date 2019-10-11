package epl.interfaces;

import epl.interfaces.Visitor;

public interface Visitable {
		
	void accept(Visitor v);
	
}
