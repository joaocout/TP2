package com.main;

import com.reflections.*;

public class Main {

    public static void main(String[] args){
        DataManager data = new DataManager();
        data.read_input("resources/input.txt");
        data.read_stopwords("resources/stopwords.txt");

        ReflectiveStopWords rsw = new ReflectiveStopWords();
        ReflectiveCounter rc = new ReflectiveCounter();
        ReflectiveOutput ro = new ReflectiveOutput();

        rsw.removeStopWords(data);
        rc.count(data);
        ro.show_counter(data);
    }
}
