package basics;

import java.util.ArrayList;

public class ArrayingClasses {

    public static void main(String[] args) {
        //vic trid najednou

        Person[] personArray = new Person[5];
        // :(
//        System.out.println(personArray[2].age);
        //ted uz bude fungovat
        personArray[2] = new Person("Karel", 22, 41.1);
        System.out.println(personArray[2].age);

        //hezci:
        ArrayList<Person> ppl = new ArrayList<>();
        ppl.add(new Person("NekdoDAlsi", 99, 21.1));
        ppl.get(0);
    }
}
class Person{
    String name;
    int age;
    double shoeSize;

    public Person(String name, int age, double shoeSize) {
        this.name = name;
        this.age = age;
        this.shoeSize = shoeSize;
    }
}
