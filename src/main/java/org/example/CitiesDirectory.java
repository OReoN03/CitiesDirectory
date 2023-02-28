package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CitiesDirectory {
    private static List<City> cities = new ArrayList<>();

    public static List<City> getCities() {
        return cities;
    }

    public static void loadCitiesFromFile(String path) {
        try {
            Scanner scanner = new Scanner(Path.of(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] cityFields = line.split(";");

                City city = new City();
                city.setName(cityFields[1]);
                city.setRegion(cityFields[2]);
                city.setDistrict(cityFields[3]);
                city.setPopulation(Long.parseLong(cityFields[4]));
                if (cityFields.length > 5) city.setFoundation(cityFields[5]);

                cities.add(city);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<City> sortCitiesByName() {
        return cities.stream()
                .sorted(Comparator.comparing(City::getName, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    public static List<City> sortCitiesByDistrictAndName() {
        return cities.stream()
                .sorted(Comparator.comparing(City::getName))
                .sorted(Comparator.comparing(City::getDistrict))
                .toList();
    }

    public static int findMaxPopulationCityIndex() {
        int maxPopulationIndex = 0;
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getPopulation() > cities.get(maxPopulationIndex).getPopulation()) {
                maxPopulationIndex = i;
            }
        }
        return maxPopulationIndex;
    }
}
