package oop.adt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetsDemo {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        words.add("Hello");
        System.out.println(words);
        words.add("Hello"); //uz tam je, vrati false
        System.out.println(words);
        words.add("World");
        System.out.println(words);


        words.remove("Hello");
        System.out.println(words);

        words.clear();
        System.out.println(words);

        //ocisteni listu
        List<String> notUniqueWords = new ArrayList<>();
        notUniqueWords.add("hello");
        notUniqueWords.add("hello");
        notUniqueWords.add("world");
        notUniqueWords.add("text");
        notUniqueWords.add("example");
        notUniqueWords.add("something");
        notUniqueWords.add("example");
        System.out.println(notUniqueWords);

        Set<String> uniqueWords = new HashSet<>(notUniqueWords);
        System.out.println(uniqueWords);
        notUniqueWords.clear();
        notUniqueWords.addAll(uniqueWords);
        System.out.println(notUniqueWords);

        //ukol: vygeneruj 100 nahodnych unikatnich cisel (0,150)
        Set<Integer> uniqueRandoms = new HashSet<>();
        while (uniqueRandoms.size() < 101){
            uniqueRandoms.add((int)(Math.random()*151));
        }
        System.out.println(uniqueRandoms);
        List<Integer> randoms = new ArrayList<>(uniqueRandoms);
        System.out.println(randoms);
    }
}
