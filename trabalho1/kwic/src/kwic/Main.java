package kwic;

import java.util.Scanner;

import kwic.base.*;
import kwic.interfaces.*;
import kwic.dblp.*;

public class Main {

	public static void main(String[] args) {
		int mode;
		System.out.println("Insira o método de busca:");
		System.out.println("1 - Arquivo texto");
		System.out.println("2 - Busca DBLP");
		Scanner sc = new Scanner(System.in);
		mode = sc.nextInt();
		new KwicFactory(mode);
		sc.close();
	}

}