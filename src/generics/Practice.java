package generics;

public class Practice<E> {

    void printArray(E[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static <T extends Comparable<T>> T getGreatest(T[] arr){
        T greatest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(greatest) > 0){
                greatest = arr[i];
            }
        }
        return greatest;
    }
    public static void main(String[] args) {
        Integer[] numbers = {5,6,3,1};
        Double[] decimals = {Math.PI, .9, -.5, 1_000_000.00001};
        String[] words = {"Alpha", "Gamma", "Test",  "running out of ideas"};

        Practice<Double> test = new Practice<>();
        test.printArray(decimals);

        System.out.println(getGreatest(numbers));
        System.out.println(getGreatest(decimals));
        System.out.println(getGreatest(words));
        //fachat nebude
//        Person a = new Person();
//        Person b = new Person();
//        Person[] people = {a,b};
//        System.out.println(getGreatest(people));
    }
}
class Person{
    int serial;
}
