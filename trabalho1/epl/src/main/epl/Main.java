package epl;

public class Main {

	public static void main(String[] args) {
		
		/*sempre que queremos utilizar o metodo "eval"
		devemos mover a referencia do visitor para o objeto desejado
		utilizando o metodo "accept"*/
		
		EvalVisitor ev = new EvalVisitor();
		PrintVisitor pv = new PrintVisitor();
		
		Literal l = new Literal(4);
		Literal k = new Literal(5);
		Add soma = new Add(l,k);
		soma.accept(pv);
		soma.accept(ev);
		pv.print();
		System.out.println(" = " + ev.eval());
		
		Literal m = new Literal(2);
		Add soma2 = new Add(soma, m);
		soma2.accept(pv);
		soma2.accept(ev);
		pv.print();
		System.out.println(" = " + ev.eval());
		
		Literal a = new Literal(13);
		Sub sub = new Sub(soma2, a);
		sub.accept(pv);
		sub.accept(ev);
		pv.print();
		System.out.println(" = " + ev.eval());
		
		Literal nove = new Literal(9);
		Mul mul = new Mul(sub, nove);
		mul.accept(pv);
		mul.accept(ev);
		pv.print();
		System.out.println(" = " + ev.eval());
		
		Literal mnoventa = new Literal(-90);
		Div div = new Div(mnoventa, mul);
		div.accept(pv);
		div.accept(ev);
		pv.print();
		System.out.println(" = " + ev.eval());
		
	}

}
