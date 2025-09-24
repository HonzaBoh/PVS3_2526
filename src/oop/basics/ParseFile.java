package oop.basics;

import fileworks.DataImport;

import java.util.ArrayList;

public class ParseFile {

    public static void main(String[] args) {
        //zkus nacist soubor
        DataImport di = new DataImport("countries.txt");
        // di.printFile();
//        System.out.println("Prvni zeme:");
/*        String countryData = di.readLine();
        //rozdel na kusy
       // ctrl + /
//        Country firstCountry = parseLine(countryData);
//
//        System.out.println(firstCountry.getContinent());
//        System.out.println(firstCountry.getAge());
//        System.out.println(firstCountry);*/
        // hasNext() - vrátí true/false

        ArrayList<Country> countries = new ArrayList<>();
        while (di.hasNext()) {
            Country country = parseLine(di.readLine());
            countries.add(country);
        }
        filterByContinent(countries, "Europe");
        maxAndMin(countries);
        avg(countries);
        di.finishImport();
    }

    static Country parseLine(String line) {
        String[] dataPieces = line.split(";");

        Country country = new Country(
                dataPieces[0],
                dataPieces[1],
                Long.parseLong(dataPieces[2]),
                Double.parseDouble(dataPieces[3])
        );

        return country;
    }

    static void filterByContinent(ArrayList<Country> c, String filter) {
        // Filter = North America
        int totalCount = 0;
        for (Country country : c) {
            if (country.getContinent().equalsIgnoreCase(filter)) {
                System.out.println(country);
                totalCount++;
            }
        }
        System.out.printf("Celkový počet zemí v %s je %d\n", filter, totalCount);
    }

    static void avg(ArrayList<Country> c){
        double total = 0;
        for(Country cr : c){
            total += cr.getAge();
        }
        System.out.println(total / c.size());
    }

    static void maxAndMin(ArrayList<Country> c) {
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < c.size(); i++) {
            if (c.get(minIndex).getSomething() > c.get(i).getSomething()) {
                minIndex = i;
            }
            if (c.get(maxIndex).getSomething() < c.get(i).getSomething()) {
                maxIndex = i;
            }
        }
        System.out.println(c.get(minIndex));
        System.out.println(c.get(maxIndex));
    }
}

class Country {
    public String name, continent;
    public long something;
    public double age;

    public Country(String name, String continent, long something, double age) {
        this.name = name;
        this.continent = continent;
        this.something = something;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public long getSomething() {
        return something;
    }

    public void setSomething(long something) {
        this.something = something;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Název: %s | Kontinent: %s | Populace: %,d | Dožití: %.2f", name, continent, something, age);
    }
}

