package kwic.base;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import kwic.interfaces.Input;

public class BaseInput implements Input {
	
	private String file_name;
	private ArrayList<String> lines;
	private FileReader file;
	private BufferedReader buff;
	
	public BaseInput(String _file_name) {
		this.file_name = _file_name;
		lines = new ArrayList<String>();
	}
	
	public String getFileName() {
		return file_name;
	}
	
	public void setFileName(String _file_name) {
		this.file_name = _file_name;
	}
	
	public ArrayList<String> getLines() {	
		
		try {
			file = new FileReader(file_name);
			buff = new BufferedReader(file);
			
			String line = buff.readLine();
			while(line!=null) {
				lines.add(line);
				line = buff.readLine();
			}
		}
		catch (Exception e) {
			System.err.printf("Error reading '%s'\n", file_name);
			e.printStackTrace();
		}
		
		return lines;
	}
	
	
	
	
}
