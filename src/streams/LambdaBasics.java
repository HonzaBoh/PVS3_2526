package streams;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface MathFunction {
    double run(double a, double b);

}

interface Printable {
    void print();
}

interface Magnitude {
    /**
     * returns number * number
     *
     * @param number
     * @return
     */
    double quadratic(double number);
}

class Addition implements MathFunction {
    @Override
    public double run(double a, double b) {
        return a + b;
    }
}

public class LambdaBasics {
    public static void printResult(MathFunction mf, double a, double b) {
        System.out.println(mf.run(a, b));
    }

    public static void main(String[] args) {
        // Implementace pomocí třídy
        MathFunction add = new Addition();

        // Implementace rozhraní pomocí anonymní vnitřní třídy
        MathFunction sub = new MathFunction() {
            @Override
            public double run(double a, double b) {
                return a - b;
            }
        };

        MathFunction nasobeni = new MathFunction() {
            @Override
            public double run(double a, double b) {
                return a * b;
            }
        };

        MathFunction alsoMultiplication = (a, b) -> a*b; //jen jako single-line
        MathFunction alsoAlsoMultiplication = (a,b) -> {
            System.out.println(a + "*" + b + "=");
            return a*b;
        };
        printResult(add, 5, 6);
        printResult(sub, 10, 4);

        // Lambda bez argumentu
        Printable printable = () -> System.out.println("ahoj");
        printable.print();

        // Lambda s argumentem
        Magnitude mag = (n) -> {
            double res = n * n;
            System.out.println(res);
            return res;
        };

        mag.quadratic(5);

        // Více argumentů + přímo ve volání
        printResult((a, b) -> a * b, 5, 6);

        List<String> names = new ArrayList<>(List.of("Pepík", "Bohuš", "Rastislav", "Emil",
                "Chrudoš", "Radegast", "Tutanchamon", "Ota"));

        // Lambda + comparator
        Comparator<String> BY_LENGTH = (n1, n2) -> Integer.compare(n1.length(), n2.length());
        Collections.sort(names, BY_LENGTH);
        System.out.println(names);

        // Musíte vědět, co děláte
        Comparator<String> BY_LENGTH_SHORT = Comparator.comparingInt(String::length);
        names.sort(BY_LENGTH_SHORT.reversed());
        System.out.println(names);

    }
}
