package com.reflections;

import java.util.ArrayList;
import java.lang.reflect.*;

public class ReflectiveStopWords {

    public void removeStopWords(Object in) {
        Class cls = in.getClass();

        Field field_text = null;
        Field field_sw = null;
        try {
            field_text = cls.getDeclaredField("text");
            field_sw = cls.getDeclaredField("stopwords");
        }
        catch (NoSuchFieldException e) {
            System.err.println("Field not found");
            e.printStackTrace();
        }
        field_text.setAccessible(true);
        field_sw.setAccessible(true);

        ArrayList<ArrayList<String>> text = null;
        ArrayList<String> stopwords = null;
        try {
            stopwords = (ArrayList<String>) field_sw.get(in);
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
                if(!stopwords.contains(word)){
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
