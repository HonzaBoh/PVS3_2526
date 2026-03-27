package streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rnd = new Random(22);

        for (int i = 0; i < 100; i++) {
            numbers.add(rnd.nextInt(150));
        }
        System.out.println(numbers);


        System.out.println("Size: " + numbers.size());

        int size = (int) numbers.stream()
                .count();
        System.out.println("Count: " + size);

        //zjisti unikaty (pocet)
        HashSet<Integer> uniques = new HashSet<>(numbers);

        //stream:
        int uniquesAmount = (int) numbers.stream()
                .distinct() //COUNT DISTINCT
                .count();

        System.out.println(uniques.size());
        System.out.println(uniquesAmount);

        //unikatni cisla > 50
        int uniquesUpper = (int) numbers.stream()
                .distinct()
                .filter(num -> num > 50)
                .count();
        System.out.println("Pocet unikatu > 50: " + uniquesUpper);

        //vypis vsechna suda cisla:
        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.print(num + " "));

        System.out.println();
        //vypis pole rovnou serazene
        numbers.stream()
//                .sorted((num1, num2) -> Integer.compare(num1, num2))
                .sorted((num1, num2) -> num2 - num1)
                .forEach(num -> System.out.print(num + ", "));

//        numbers.stream()
//                .sorted(Integer::compareTo)
//                .forEach(System.out::println);

        System.out.println();
        //Vypis prumer pole:
        double avg = numbers.stream()
                .mapToDouble(Integer::doubleValue) //v tride Integer, najdi metodu doubleValue
                .average()
                .orElse(0);
        System.out.println("AVG: " + avg);

        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        String[] names = {"Lakatosh", "Pankrac", "Toshiba", "Konstantin", "Poli", "Verka"};
        Stream.of(names)
                .sorted((name1, name2) -> name2.length() - name1.length())
                .forEach(System.out::println);
    }

}
