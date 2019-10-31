package com.reflections;

import com.main.DataManager;

import java.util.ArrayList;
import java.lang.reflect.*;

public class ReflectiveOutput {

    public void show_counter(DataManager in){
        Class cls = in.getClass();

        Field field_words = null;
        Field field_count = null;
        try {
            field_words = cls.getDeclaredField("words");
            field_count = cls.getDeclaredField("count");
        }
        catch (NoSuchFieldException e) {
            System.err.println("Field not found");
            e.printStackTrace();
        }
        field_count.setAccessible(true);
        field_words.setAccessible(true);

        ArrayList<String> words = null;
        int[] count = null;
        try {
            words = (ArrayList<String>) field_words.get(in);
            count = (int[]) field_count.get(in);

        }
        catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }

        int index = 0;
        for(String word : words){
            System.out.println(word + " = " + count[index]);
            index++;
        }
    }

}
