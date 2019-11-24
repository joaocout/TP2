package com.reflections;

import java.util.ArrayList;
import java.lang.reflect.*;
import com.util.Pair;

public class ReflectiveOutput {

    public void show_counter(Object in){
        Class cls = in.getClass();

        Field field_word_frequency = null;
        try {
            field_word_frequency = cls.getDeclaredField("word_frequency");
        }
        catch (NoSuchFieldException e) {
            System.err.println("Field not found");
            e.printStackTrace();
        }
        field_word_frequency.setAccessible(true);

        ArrayList<Pair<String,Integer>> word_frequency = null;
        try {
            word_frequency = (ArrayList<Pair<String, Integer>>) field_word_frequency.get(in);
        }
        catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }

        for(Pair<String,Integer> word : word_frequency){
            System.out.println(word.getFirst() + " = " + word.getSecond());
        }
    }

}
