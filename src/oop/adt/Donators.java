package oop.adt;

import fileworks.DataImport;

import java.util.*;

public class Donators {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/blood.txt");

        List<Donator> valuableResources = new ArrayList<>();

        while(di.hasNext()){
            String[] parts = di.readLine().trim().split(",");
            valuableResources.add(new Donator(parts[0], parts[1],
                    parts[2].equals("Female"), Integer.parseInt(parts[3])));
        }

        // kolik dárcovství krve O+ bylo realizováno za soubor
        System.out.println(valuableResources.size());
        System.out.println(filterByBloodType(valuableResources, "O+").size());

        // funkci která mi vrátí seznam unikátních dárcu konrétní krevní skupiny
        System.out.println(uniqueFilter(valuableResources, "O+").size());

        // Všechny skupiny
        String[] bts = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        for(String bt : bts){
            System.out.println(uniqueFilter(valuableResources, bt).size());
        }

        di.finishImport();
    }

    public static List<Donator> filterByBloodType(List<Donator> people, String bt){
        List<Donator> filtered = new ArrayList<>();

        for(Donator karel : people){
            if(karel.bloodType.equals(bt)){
                filtered.add(karel);
            }
        }

        return filtered;
    }

    public static Set<Donator> uniqueFilter(List<Donator> people, String bt){
        // filter by bt
        List<Donator> filtered = filterByBloodType(people, bt);

        // remove duplicates
        Set<Donator> unique = new HashSet<>();

        for(Donator p : filtered){
            unique.add(p);
        }

        return unique;
    }
}


class Donator{
    String name;
    String bloodType;
    boolean isWoman;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Donator donator = (Donator) o;
        return isWoman == donator.isWoman && age == donator.age && Objects.equals(name, donator.name) && Objects.equals(bloodType, donator.bloodType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bloodType, isWoman, age);
    }


    public Donator(String name, String bloodType,
                   boolean isWoman, int age) {
        this.name = name;
        this.bloodType = bloodType;
        this.isWoman = isWoman;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Donator{" +
                "name='" + name + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", isWoman=" + isWoman +
                ", age=" + age +
                '}';
    }
}