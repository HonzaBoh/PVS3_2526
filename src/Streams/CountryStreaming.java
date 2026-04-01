package Streams;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class CountryStreaming {
    static void main() {
        String path = "data/countries.txt";

        List<Country> countries = new ArrayList<>();
        
        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            
            for(String line : lines){
                String[] parts = line.trim().split(";");
                countries.add(new Country(
                        parts[0], 
                        parts[1], 
                        Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3])
                        )
                );
            }
            
            long worldPopulation = countries.stream().
                    mapToLong(Country::getPopulation).
                    sum();
            System.out.println("Celková populace je " + worldPopulation);
            
            double avgPopulation = countries.stream().
                    mapToInt(Country::getPopulation).
                    average().
                    orElse(0);
            System.out.println("Průměrná populace je " + avgPopulation);

            IntSummaryStatistics statistics = countries.stream()
                    .mapToInt(Country::getPopulation)
                    .summaryStatistics();
            System.out.println("Statistiky: " + statistics);
            
            int totalPopulationOfNA = countries.stream()
                    .filter(Country -> Country.getContinent().equalsIgnoreCase("North America"))
                    .mapToInt(Country::getPopulation)
                    .sum();
            System.out.println("Celková populace v Severní Americe je " + totalPopulationOfNA);
            
            double avgLifeOfAsia = countries.stream()
                    .filter(country -> country.getContinent().equalsIgnoreCase("Asia"))
                    .mapToDouble(Country::getAvgLife)
                    .average()
                    .orElse(0);
            System.out.println("Průměrná délka života v Asii je " + avgLifeOfAsia);
            
            ArrayList<String> continents = new ArrayList<>();
            for (Country country : countries) {
                if (!continents.contains(country.getContinent())) {
                    continents.add(country.getContinent());
                }
            }
            System.out.println("Kontinenty: " + continents);
            for (String continent : continents) {
                int stateCountOfEaachContinent = Math.toIntExact(countries.stream()
                        .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                        .count());
                System.out.println("Počet států v " + continent + " je " + stateCountOfEaachContinent);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            
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

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avgLife=" + avgLife +
                '}';
    }
}
