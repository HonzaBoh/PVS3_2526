package oop.adt;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Listing {

    public static void main(String[] args) {
        //list je z java.util, awt je GUI, zatim nepouzivat
        List<Integer> my;

        List<Integer> integers = new ArrayList<>();

        //pridani
        for (int i = 1; i < 20; i++) {
            integers.add(i);
        }

        //priadni vice veci
        List<Integer> toAdd = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            toAdd.add(i);
        }
        integers.addAll(toAdd);

        //ziskani/vypsani
        System.out.println(integers);

        //horsi:
        System.out.println(integers.get(0));

        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        System.out.println(words.get(0));

        //odstraneni
        integers.remove(0);
        words.remove(0);
        //hleda equals hodnoty
        words.remove("hello");



        //velikost:
        System.out.println(integers.size());

        System.out.println(integers.get(integers.size()-1));

        //upravy:
        integers.set(4,6);//nachylne na blbost (ArrayIndexOutOfBounds)
        integers.add(2,42);//nesmaze, co je na 2, posune

        //"gimmicks"
        Collections.shuffle(integers);
        System.out.println(integers);

        Collections.max(integers);
        Collections.min(integers);
//        words.sort();
        //...


        //prvek je v listu prave jednou:
        words.add("hello");
        words.add("world");
        words.add("helo");
        words.add("hello");
        System.out.println(isOnlyOnce(words, "world"));
        System.out.println(isOnlyOnce(words,"hello"));
    }

    static boolean isOnlyOnce(List<String> words, String word){
        if (!words.contains(word)){
            System.out.println(word + " neni v kolekci vubec");
            return false;
        }
        return words.indexOf(word) == words.lastIndexOf(word);
    }
}
