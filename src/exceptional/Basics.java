package exceptional;
import java.io.IOException;
import java.util.Scanner;

public class Basics {

    public static int division(int a, int b) {
        return a/b;
    }

    static void countingWithPause(int countTo) throws InterruptedException {
        for (int i = 0; i < countTo; i++) {
            System.out.println(i);
            magicPause(5);
        }
    }

    static void magicPause(int amount) throws InterruptedException {
        System.out.println("Program zastavuje na " + amount + " sekund...");
        //zodpovedne:
//        try {
//            Thread.sleep(amount * 1000L);
//        } catch (InterruptedException e) {
//            System.out.println("Program died during sleep :)");
//        }
        Thread.sleep(amount * 1000L);
        System.out.println("Wakey, wakey");
    }

    static void parryThis() {
        throw new ArrayIndexOutOfBoundsException();
    }
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[]{1,5,3};
        System.out.println(array[0]);
//        System.out.println(array[3]);

        Scanner sc = new Scanner("2");
        System.out.println("Zadej cislo");
        System.out.println(Double.parseDouble("5.6"));
//        System.out.println(Double.parseDouble("5,6"));
        try {
            int input = sc.nextInt();
            System.out.println("Vysledek = " + (5/input));
            System.out.println("Try finished");
        } catch (ArithmeticException a){
            System.out.println("Demente, nulou nedel");
        } catch (NumberFormatException e){
            System.out.println("Zadej cislo");
            System.err.println("Doopravdy cislo");
        }
//        String neco = "neco";
//        neco = null;
//        System.out.println(neco.length());


        //jak to nedelat:
        try{
            System.out.println(array[5]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("whoops");
        }
        catch (Exception e){
            System.out.println(":(");
        }

        System.out.println("Taky vysledek = " + division(5,6));
//        magicPause(4);

        countingWithPause(3);
        System.out.println("Happy ending");


    }
}
