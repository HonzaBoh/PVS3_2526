package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CitiesStreaming {
    public static void main(String[] args) {
        String path = "data/Cities.txt";
        List<City> cities = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(path));

            for(String line : lines){
                String[] parts = line.trim().split(",");
                cities.add(new City(parts[0], parts[1], parts[2]));
            }

            // unikátní kontinenty
            cities.stream()
                    .map(city -> city.getContinent())
                    .distinct()
                    .forEach(city -> System.out.println(city));

            // všechny města Finska
            cities.stream()
                    .filter(city -> city.getCountryName().equalsIgnoreCase("Finland"))
                    .map(city -> city.getName())
                    .distinct()
                    .forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

class City {
    String name;
    String countryName;
    String continent;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", countryName='" + countryName + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }

    public City(String name, String countryName, String continent) {
        this.name = name;
        this.countryName = countryName;
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}