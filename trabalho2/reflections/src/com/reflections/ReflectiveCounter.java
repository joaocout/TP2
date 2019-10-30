package com.reflections;

import com.main.Text_Data;

import java.util.ArrayList;
import java.lang.reflect.*;

public class ReflectiveCounter {

    public void count(Text_Data in) {
        Class cls = in.getClass();

        Field field_text = null;
        Field field_words = null;
        Field field_count = null;
        try{
            field_text = cls.getDeclaredField("text");
            field_words = cls.getDeclaredField("words");
            field_count = cls.getDeclaredField("count");
        }
        catch (NoSuchFieldException e){
            System.err.println("Field not found");
            e.printStackTrace();
        }
        field_text.setAccessible(true);
        field_words.setAccessible(true);
        field_count.setAccessible(true);

        ArrayList<ArrayList<String>> text = null;
        try {
            text = (ArrayList<ArrayList<String>>) field_text.get(in);
        } catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }
        ArrayList<String> words = new ArrayList<>();

        for (ArrayList<String> line : text)
            for (String word : line)
                if(!words.contains(word))
                    words.add(word);

        int[] count = new int[(words.size())];
        int index = 0;
        for(String word : words){
            for(ArrayList<String> line : text)
                for(String txt_word : line)
                    if(word.equals(txt_word))
                        count[index]++;
            index++;
        }

        try {
            field_count.set(in, count);
            field_words.set(in, words);

        } catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }
    }

}