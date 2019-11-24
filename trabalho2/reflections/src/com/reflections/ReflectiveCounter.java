package com.reflections;

import java.util.ArrayList;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

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

        /*words.sort(new Comparator<Object>() {
            @Override
            public int compare(Object a, Object b) {
                return count[words.indexOf(b)] - count[words.indexOf(a)];
            }
        });

        Arrays.sort(count);
        reverse(count, words.size());*/

        try {
            field_count.set(in, count);
            field_words.set(in, words);

        } catch (IllegalAccessException e) {
            System.err.println("Field isn't accessible");
            e.printStackTrace();
        }

    }

}