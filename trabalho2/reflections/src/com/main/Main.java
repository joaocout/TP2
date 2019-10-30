package com.main;

import com.reflections.*;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Text_Data in = new Text_Data("resources/input.txt");
        ReflectiveStopWords rsw = new ReflectiveStopWords("resources/stopwords.txt");
        ReflectiveCounter rc = new ReflectiveCounter();
        ReflectiveOutput ro = new ReflectiveOutput();

        in.readfile(); //leitura do arquivo
        rsw.readfile(); //leitura do arquivo

        rsw.removeStopWords(in);
        rc.count(in);
        ro.show(in);
    }
}
