package Streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CitiesStreaming {
    static void main() {
        String path = "data/Cities.txt";

        List<City> cities = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            
            for(String line : lines){
                String[] parts = line.trim().split(",");
                cities.add(new City(parts[0], parts[1], parts[2]));
            }
            
            cities.stream().
                    map(City::getContinent).
                    distinct().
                    forEach(System.out::println);
            
            cities.stream().
                    filter(city -> city.getCountry().equalsIgnoreCase("Finland")).
                    map(City::getName).
                    distinct().
                    forEach(System.out::println);
                    
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            
    }
    
    
}
class City {
    String name;
    String country;
    String continent;

    public City(String name, String country, String continent) {
        this.name = name;
        this.country = country;
        this.continent = continent;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", continent='" + continent + '\'' +
                '}';
    }
}
