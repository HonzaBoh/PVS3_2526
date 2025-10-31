package generics;

import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        Integer[] array = {4, 2, 1, 8, 6, 9, 8, 8, 8, 8, 8, 8};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    static <T extends Comparable<T>> void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
