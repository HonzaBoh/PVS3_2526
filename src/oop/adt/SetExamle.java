package oop.adt;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetExamle {
    public static void main(String[] args) {
        Set<Point> set = new HashSet<>();

        Point p0 = new Point(6.4, Math.E);
        Point p1 = new Point(.4, Math.PI);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(6.4, 3.2);
        Point p4 = new Point(6.4, 3.2);
        Point p5 = new Point(6, 8);

        set.add(p0);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        set.add(p5);

        System.out.println(set.size());
    }
}

class Point{
    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(x, point.x) == 0 && Double.compare(y, point.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}