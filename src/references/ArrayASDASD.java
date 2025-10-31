package references;

import java.util.Arrays;



public class ArrayASDASD {
    public static void main(String[] args){
        int num = 5;
        int[] arr = {1, 2, 3, 4};

        square(num);
        squareArr(arr);

        System.out.println(num);
        System.out.println(Arrays.toString(arr));

    }

    static void square(int a){
        a = a * a;
        System.out.println(a);
    }

    static void squareArr(int[] a){
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }
    }
}
