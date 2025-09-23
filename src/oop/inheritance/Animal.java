package oop.inheritance;

public class Animal {
    int noseLenght;
    int legs;
    int heads;

    String nationality;
    double avgNoseLength;
    boolean isAlive;

    void eat() {
    }

    public static void main(String[] args) {
        Animal an = new Animal();
        Dog Tim = new Dog();
        Pig pig = new Pig();
        pig.futureBacon = true;

    }
}

class Dog extends Animal {
    String plemeno;

    void makeNoise() {}
}


class Pig extends Animal {
    boolean futureBacon;
}

