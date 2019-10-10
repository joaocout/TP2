package kwic.html;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import kwic.interfaces.Output;

public class HTMLOutput implements Output {
	
	public HTMLOutput() {}
	
	@Override
	public void run(ArrayList<String> lines) {
		String file_data = "<!DOCTYPE html>"
				+ "			<html>"
				+ "			<head>"
				+ "			<title>Key-Word in Context</title>"
				+ "			</head>"
				+ "			<body>"
				+ "			<ul>";
		
		for(String linha : lines) {
			file_data += "<li>" + linha + "</li>";
		}
		
		file_data += "</ul></body></html>";
		
		try {
			Files.write(Paths.get("kwic.html"), file_data.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
