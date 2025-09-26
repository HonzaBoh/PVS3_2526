package oop.inheritance;

public class Doctor {
    String name;
    int salary;

    public Doctor(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong...");
    }

    @Override
    public String toString() {
        return name + ": " + salary;
    }

    public int getSalary() {
        return salary;
    }
}
