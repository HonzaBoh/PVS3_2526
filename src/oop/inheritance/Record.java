package oop.inheritance;

public class Record {
    int length;
    String name;

    void play() {
        System.out.println("Hraju " + name);
    }
}

class Vinyl extends Record {
    int speed;
}

class Mp3 extends Record{
    boolean isCompressed;
    void compression(){
        System.out.println("komprese probíha, vyčkejte prosím :-)");
    }
}

class Wav extends Record{
    boolean broken = true;
}