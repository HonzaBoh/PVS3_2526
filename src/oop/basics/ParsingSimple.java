package oop.basics;

import java.util.Arrays;

public class ParsingSimple {
    public static void main(String[] args) {
        String neco = "Tady je cislo:3";
        //tokenizace
        String[] arr = neco.split(":");
        System.out.println(Arrays.toString(arr));
        int num = Integer.parseInt(arr[1]);

        //kolik je cislo ve stringu + 2
        //vypis do konzole
        System.out.println(num + 2);
    }

}
