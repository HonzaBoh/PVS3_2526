package oop.inheritance;

public class CardiacSurgeon extends Surgeon {
    final static int CARDIO_BONUS = 50000;

    public CardiacSurgeon(String name, int salary) {
        super(name, salary);
        this.salary += CARDIO_BONUS;
    }

    public void cardiacSurgery(){
        System.out.println("Cut my heart into pieces...");
        salary += 95_000;
    }
}
