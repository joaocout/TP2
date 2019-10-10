package epl;

public class Main {

	public static void main(String[] args) {
		
		EvalVisitor ev = new EvalVisitor();
		
		Literal l = new Literal(4);
		Literal k = new Literal(5);
		
		Add soma = new Add(l,k);
		soma.print();
		soma.accept(ev);
		System.out.println(" = " + ev.eval());
		
		Literal m = new Literal(2);
		
		Add soma2 = new Add(soma, m);
		soma2.print();
		soma2.accept(ev);
		System.out.println(" = " + ev.eval());
		
		/*sempre que queremos utilizar o metodo "eval"
		devemos mover a referencia do visitor para o objeto desejado
		utilizando o metodo "accept"*/
		Literal a = new Literal(13);
		Sub sub = new Sub(soma2, a);
		sub.print();
		sub.accept(ev);
		System.out.println(" = " + ev.eval());
		
		Literal nove = new Literal(9);
		Mul mul = new Mul(sub, nove);
		mul.print();
		mul.accept(ev);
		System.out.println(" = " + ev.eval());
		
		Literal mnoventa = new Literal(-90);
		Div div = new Div(mnoventa, mul);
		div.print();
		div.accept(ev);
		System.out.println(" = " + ev.eval());
		
	}

}
