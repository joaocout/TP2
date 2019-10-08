package epl;

public class Main {

	public static void main(String[] args) {
		Literal l = new Literal(4);
		Literal k = new Literal(5);
		Add soma = new Add(l,k);
		Literal m = new Literal(2);
		Add soma2 = new Add(soma, m);
		
		soma2.print();
	}

}
