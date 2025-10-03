package oop.inheritance;

public class Doctor {
    final int PENALTY = 50_000;
    String name;
    int salary;

    public Doctor(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void diagnose(){
        System.out.println("Figuring out what's wrong...");
        salary += 10_000;
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }

    public int getSalary() {
        return salary;
    }

    public void penalty(){
        System.out.println("Penalty required");
        salary -= PENALTY;
    }
}
