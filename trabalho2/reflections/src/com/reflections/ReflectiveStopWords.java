package com.reflections;

import com.main.Text_Data;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.*;

public class ReflectiveStopWords {

    private String file_name;
    private ArrayList<String> stop_words;

    public ReflectiveStopWords(String file_name){
        stop_words = new ArrayList<>();
        this.file_name = file_name;
    }

    public void readfile(){
        try{
            FileReader file = new FileReader(file_name);
            BufferedReader buff = new BufferedReader((file));
            String word = buff.readLine();
            while(word!=null){
                stop_words.add(word);
                word = buff.readLine();
            }
        }
        catch (Exception e) {
            System.err.printf("Error reading %s\n", file_name);
            e.printStackTrace();
        }
    }

    public void removeStopWords(Text_Data in) {
        Class cls = in.getClass();

        Field field_text = null;
        try {
            field_text = cls.getDeclaredField("text");
        }
        catch (NoSuchFieldException e) {
            System.err.println("Field not found");
            e.printStackTrace();
        }
        field_text.setAccessible(true);

        ArrayList<ArrayList<String>> text = null;
        try {
            text = (ArrayList<ArrayList<String>>) field_text.get(in);
        }
        catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(ArrayList<String> line : text){
            ArrayList<String> result_line = new ArrayList<>();
            for(String word : line){
                if(!stop_words.contains(word)){
                    result_line.add(word);
                }
            }
            result.add(result_line);
        }

        try {
            field_text.set(in, result);
        } catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }
    }

}
