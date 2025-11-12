package oop.adt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * Pomocná třída pro práci s celočíselným polem.
 */
public class ArrayUtils {

    /**
     * Metoda vypíše všechny prvky v poli <b>arr</b>.
     * Jednotlivé prvky mohou být vypsány na jeden řádek oddělené mezerou
     * nebo na více řádků, podle implementace.
     *
     * @param arr celočíselné pole, jehož obsah má být vypsán
     */
    public void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i] + "| ");
        }
        System.out.print("]\n");

    }

    /**
     * Metoda porovná dvě celočíselná pole a určí, zda jsou shodná.
     * Pole jsou shodná, pokud mají stejnou délku a stejné hodnoty
     * na stejných indexech.
     *
     * @param arr1 první pole
     * @param arr2 druhé pole
     * @return true pokud jsou obě pole shodná, jinak false
     */
    public boolean equals(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * Metoda vrátí největší prvek v poli.
     *
     * @param arr vstupní celočíselné pole
     * @return největší nalezená hodnota v poli
     */
    public int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    /**
     * Metoda vrátí nejmenší prvek v poli.
     *
     * @param arr vstupní celočíselné pole
     * @return nejmenší nalezená hodnota v poli
     */
    public int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    /**
     * Metoda vrátí aritmetický průměr všech prvků v poli.
     *
     * @param arr vstupní celočíselné pole
     * @return průměrná hodnota prvků pole jako desetinné číslo
     */
    public double getAverage(int[] arr) {
        return sum(arr) / arr.length;
    }

    /**
     * Metoda vrátí součet všech prvků v poli.
     *
     * @param arr vstupní celočíselné pole
     * @return celkový součet všech prvků v poli
     */
    public int sum(int[] arr) {
        int suma = 0;

        for(int prvek : arr){
            suma += prvek;
        }

        return suma;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayUtils a = new ArrayUtils();
        a.printArray(arr);
        System.out.println(a.getMax(arr));
        System.out.println(a.getMin(arr));
        System.out.println(a.getAverage(arr));
        System.out.println(a.sum(arr));
    }
}
