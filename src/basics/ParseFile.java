package basics;

import fileworks.DataImport;

public class ParseFile {

    public static void main(String[] args) {
     //zkus nacist soubor
        DataImport di = new DataImport("countries.txt");
        di.printFile();
        System.out.println("Prvni zeme:");
        String countryData = di.readLine();
        //rozdel na kusy
        String[] dataPieces = countryData.split(";");
        Country firstCountry = new Country(
                dataPieces[0],
                dataPieces[1],
                Long.parseLong(dataPieces[2]),
                Double.parseDouble(dataPieces[3])
        );
        System.out.println(firstCountry.getContinent());
        System.out.println(firstCountry.getAge());
        di.finishImport();
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
}

