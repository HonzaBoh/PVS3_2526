package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class CountriesStreaming {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        List<Country> countries = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(path));

            for (String line : lines) {
                String[] parts = line.trim().split(";");
                countries.add(new Country(parts[0], parts[1],
                        Integer.parseInt(parts[2]), Double.parseDouble(parts[3])));
            }

            long suma = countries.stream()
                    .mapToLong(country -> country.getPopulation())
                    .sum();

            System.out.println("Celková populace: " + suma);

            double avg = countries.stream()
                    .mapToInt(country -> country.getPopulation())
                    .average()
                    .orElse(0);

            System.out.println(avg);


            IntSummaryStatistics statistics = countries.stream()
                    .mapToInt(country -> country.getPopulation())
                    .summaryStatistics();

            System.out.println(statistics);

            // populace severní ameriky
            int totalPopulationNA = countries.stream()
                    .filter(country -> country.getContinent().equalsIgnoreCase("North America"))
                    .mapToInt(country -> country.getPopulation())
                    .sum();

            System.out.println(totalPopulationNA);

            double avgLifeAsia = countries.stream()
                    .filter(country -> country.getContinent().equalsIgnoreCase("Asia"))
                    .mapToDouble(country -> country.getAvgLife())
                    .average().orElse(0);
            System.out.println(avgLifeAsia);

            String[] continents = {"Asia", "North America", "South America", "Africa", "Europe", "Oceania"};
            for(String continent : continents){
                System.out.println(continent + ": " + countCountries(countries, continent));
            }

        } catch (IOException e) {
            System.out.println("failed loading the file");
        }
    }

    public static long countCountries(List<Country> countries, String continent){
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .count();
    }
}

class Country {
    String name;
    String continent;
    int population;
    double avgLife;

    public Country(String name, String continent, int population, double avgLife) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgLife = avgLife;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avgLife=" + avgLife +
                '}';
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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getAvgLife() {
        return avgLife;
    }

    public void setAvgLife(double avgLife) {
        this.avgLife = avgLife;
    }
}
