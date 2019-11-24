package com.reflections;

import java.util.ArrayList;
import java.lang.reflect.*;
import java.util.Comparator;
import com.util.Pair;

public class ReflectiveCounter {

    private void reverse (int[] a, int size){
        for(int i = 0; i<size/2; i++){
            int temp = a[i];
            a[i] = a[size-i-1];
            a[size-i-1] = temp;
        }
    }

    public void count(Object in) {
        Class cls = in.getClass();

        Field field_text = null;
        Field field_word_frequency = null;
        try{
            field_text = cls.getDeclaredField("text");
            field_word_frequency = cls.getDeclaredField("word_frequency");
        }
        catch (NoSuchFieldException e){
            System.err.println("Field not found");
            e.printStackTrace();
        }
        field_text.setAccessible(true);
        field_word_frequency.setAccessible(true);

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

        ArrayList<Pair<String,Integer>> result = new ArrayList<>();
        for(int i = 0; i < words.size(); i++){
            result.add(new Pair (words.get(i), count[i]));
        }

        result.sort(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> a, Pair<String, Integer> b) {
                return b.getSecond() - a.getSecond();
            }
        });

        try {
            field_word_frequency.set(in, result);
        } catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }

    }

}