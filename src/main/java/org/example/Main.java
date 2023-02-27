package org.example;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class City {
        private String name;
        private String region;
        private String district;
        private long population;
        private String foundation;

        public City() {}

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", district='" + district + '\'' +
                    ", population=" + population +
                    ", foundation='" + foundation + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        String path = "src/main/resources/Задача ВС Java Сбер.csv";
        List<City> cities = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Path.of(path));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] cityFields = line.split(";");

                City city = new City();
                city.name = cityFields[1];
                city.region = cityFields[2];
                city.district = cityFields[3];
                city.population = Long.parseLong(cityFields[4]);
                if (cityFields.length > 5) city.foundation = cityFields[5];

                cities.add(city);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (City city : cities) {
            System.out.println(city);
        }
    }
}