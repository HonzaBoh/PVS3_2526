package oop.inheritance;

public class Surgeon extends Doctor {

    final static int SURGEON_BONUS = 30000;

    public Surgeon(String name, int salary) {
        //omezeni: kdyz to, od ceho dedim, ma konstruktor
        //-> ja musim mit minimalne stejnej
        super(name, salary);
        this.salary += SURGEON_BONUS;
    }

    public void surgery(){
        salary += 45_000;
        System.out.println("Cutting open...");
    }
}
