package oop.inheritance;

public class Hunter {
    String name;
    int gold;

    public Hunter(String name) {
        this.name = name;
        gold = 10;
    }

    public void hunt(){
        System.out.println(name + " is hunting a beast");
        gold += 10;
    }
}
