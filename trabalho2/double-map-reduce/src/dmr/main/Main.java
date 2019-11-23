package dmr.main;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.lang.Thread;

class Main {
    private static final int PROCESSORS = 5;
    private static final int RESULTS = 20;

    private static ArrayList<ArrayList<Tuple<String,Integer>>> mapped_strs;
    private static ArrayList<String> stop_words;
    private static HashMap<String, ArrayList<Tuple<String,Integer>>> regrouped;
    private static ArrayList<Tuple<String,Integer>> counted;

    // regroups the mapped_strs into regrouped = [ "he": [{'he',1}, {'he', 1}], "they": [...]]
    private static void Regroup() {
        regrouped = new HashMap<>();
        for(ArrayList<Tuple<String,Integer>> sublist : mapped_strs) { // for each line
            for(Tuple<String, Integer> tp : sublist) {
                if(!regrouped.containsKey(tp.first))
                    regrouped.put(tp.first, new ArrayList<>());
                
                regrouped.get(tp.first).add(tp);
            }
        }
    }

    // reads through the line, splits all " ", removes stop words, and adds (word, 1) to arrlist
    // map
    static class Map implements Runnable {
        String line;
        Map(String line) { this.line = line.trim(); }

        @Override
        public void run() {
            String[] lines = line.split(" ");
            ArrayList<Tuple<String,Integer>> line_words = new ArrayList<>();
            for(String word : lines) {
                word = word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                if(!stop_words.contains(word) && word != "")
                    line_words.add(new Tuple(word, 1));
            }

            if(!line_words.isEmpty())
                mapped_strs.add(line_words);
            //try { Thread.sleep(1); } catch(Exception ex) { }
        }
    }

    // sets counted = [ {word, freq}, {word, freq}] with the sum of the occurences in each subarray
    // reduce
    public static void Count() {
        counted = new ArrayList<>();

        for(String key : regrouped.keySet()) {
            Tuple<String,Integer> t = new Tuple(key, regrouped.get(key).size());
            counted.add(t);
        }
    }

    public static void main(String[] args) {
        mapped_strs = new ArrayList<>();
        stop_words = new ArrayList<>();
        try {
            // reads stop swords
            File sw = new File("res/stopwords.txt");
            Scanner scan = new Scanner(sw);
            while(scan.hasNextLine()) {
                String stopword = scan.nextLine();
                stop_words.add(stopword);
            }
            scan.close();
            
            // reads whole file
            File in = new File("res/input.txt");
            scan = new Scanner(in);

            ArrayList<Thread> threads = new ArrayList<>(); // stores all threads
            while(scan.hasNextLine()) { // maps each line
                String readStr = scan.nextLine();
                Thread t = new Thread(new Map(readStr));
                threads.add(t);
                t.start();
            }

            // waits till all the processing ends
            while(!threads.isEmpty()) {
                Iterator<Thread> it = threads.iterator();
                while(it.hasNext()) {
                    Thread t = it.next();
                    if(!t.isAlive())
                        it.remove();
                }
            }

            // regroups all words
            Regroup();

            // counts each occurence in the subarrays
            Count();

            // sorts descending
            Collections.sort(counted, new Comparator<Tuple<String,Integer>>() {
                @Override
                public int compare(Tuple<String,Integer> a, Tuple<String,Integer> b) {
                    return b.second - a.second;
                }
            });

            // prints output
            int i = 0;
            for(Tuple<String,Integer> t : counted) {
                System.out.println(t);
                i++;
                if(i == RESULTS)
                    break;
            }

            scan.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}