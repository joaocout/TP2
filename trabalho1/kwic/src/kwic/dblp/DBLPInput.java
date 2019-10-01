package kwic.dblp;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import kwic.interfaces.Input;


public class DBLPInput implements Input {

	ArrayList<String> lines;
	public DBLPInput() {
		try {
			lines = new ArrayList<String>();
			
			System.out.println("Insira o criterio de busca (autor, titulo, etc): ");
			Scanner sc = new Scanner(System.in);
			String query = sc.nextLine();
			sc.close();
			
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
			Document doc = builder.parse("https://dblp.org/search/publ/api?format=xml&q=" + query);
			NodeList nl = doc.getElementsByTagName("title");
			for(int i=0; i < nl.getLength(); i++) {
				Node n = nl.item(i);
				// remove o ponto final (caso tenha)
				String r = n.getTextContent();
				if(r.substring(r.length() - 1).equals(".")) {
					r = r.substring(0, r.length() - 1);
				}
				lines.add(r);
			}
			
		} catch(Exception e) {
			System.err.printf("Erro ao buscar utilizando o criterio desejado.");
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<String> getLines() {
		return this.lines;
	}

}
