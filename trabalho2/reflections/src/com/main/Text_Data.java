package com.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Text_Data {

    private String file_name;
    private ArrayList<ArrayList<String>> text; //matriz que armazena todas as palavras
    private ArrayList<String> words; //armazena as palavras individualmente
    private int[] count; //armazena a frequencia de cada palavra

    public Text_Data(String file_name) {
        this.file_name = file_name;
    }

    //separa todas as palavras do arquivo em strings dentro de arrays
    public void readfile(){
        try{
            FileReader file = new FileReader(file_name);
            BufferedReader buff = new BufferedReader(file);
            text = new ArrayList<>();
            String line = buff.readLine();
            while(line!=null){
                line = line.replaceAll("[(){}<>,.;!?]", "");
                ArrayList<String> words_in_line = new ArrayList<>(Arrays.asList(line.split(" ")));
                text.add(words_in_line);
                line = buff.readLine();
            }
            buff.close();
            file.close();
        }
        catch(Exception e){
            System.err.printf("Error reading %s\n", file_name);
            e.printStackTrace();
        }
    }

}
