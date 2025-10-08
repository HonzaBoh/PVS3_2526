package oop.interfaces;

import java.util.Objects;

public class Equalizer {
    public static void main(String[] args) {
        String a = "neco";
        String b = "neco";

        System.out.println(a.equals(b));
        System.out.println(a == b); // trochu specialni pripad
        a += " dalsiho";
        b += " dalsiho";

        System.out.println(a.equals(b));
        System.out.println(a == b); // :(

        Coordinate first = new Coordinate(1, 3);
        Coordinate second = new Coordinate(1, 3);

        System.out.println(first == second); // :(
        //proc tohle hodi false?
        // pouzije defaultni u objektu
        System.out.println(first.equals(second));
        //takhle je treba defaultni toString()
        System.out.println(first);


    }
}
class Coordinate{
    int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
