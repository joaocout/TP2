package com.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DataManager {

    private ArrayList<ArrayList<String>> text; //matriz que armazena todas as palavras
    private ArrayList<String> stopwords; //array que armazena as stop words
    private ArrayList<String> words; //armazena as palavras individualmente
    private int[] count; //armazena a frequencia de cada palavra

    //remove todas as "palavras" de size menor que 2
    private void normalize(ArrayList<String> a){
        for(int i = 0; i<a.size(); i++){
            if(a.get(i).length() < 2){
                a.remove(i);
            }
        }
    }

    //separa todas as palavras do arquivo em strings dentro de arrays
    public void read_input(String input_filename){
        try{
            FileReader file = new FileReader(input_filename);
            BufferedReader buff = new BufferedReader(file);
            text = new ArrayList<>();
            String line = buff.readLine();
            while(line!=null){
                line = line.toLowerCase();
                line = line.replaceAll("[^a-zA-Z0-9]+", " ");
                ArrayList<String> words_in_line = new ArrayList<>(Arrays.asList(line.split(" ")));
                normalize(words_in_line);
                text.add(words_in_line);
                line = buff.readLine();
            }
            buff.close();
            file.close();
        }
        catch(Exception e){
            System.err.printf("Error reading %s\n", input_filename);
            e.printStackTrace();
        }
    }

    public void read_stopwords(String sw_filename){
        try{
            stopwords = new ArrayList<>();
            FileReader file = new FileReader(sw_filename);
            BufferedReader buff = new BufferedReader(file);
            String word = buff.readLine();
            while(word!=null){
                stopwords.add(word);
                word = buff.readLine();
            }
            buff.close();
            file.close();
        }
        catch (Exception e) {
            System.err.printf("Error reading %s\n", sw_filename);
            e.printStackTrace();
        }
    }

}
