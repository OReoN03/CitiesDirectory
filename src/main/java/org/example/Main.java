package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/Задача ВС Java Сбер.csv";
        CitiesDirectory.loadCitiesFromFile(path);

        /*List<City> cities = CitiesDirectory.getCities();
        for (City city : cities) {
            System.out.println(city);
        }
        System.out.println();

        cities = CitiesDirectory.sortCitiesByName();
        for (City city : cities) {
            System.out.println(city);
        }
        System.out.println();

        cities = CitiesDirectory.sortCitiesByDistrictAndName();
        for (City city : cities) {
            System.out.println(city);
        }*/
        int index = CitiesDirectory.findMaxPopulationCityIndex();
        long population = CitiesDirectory.getCities().get(index).getPopulation();
        System.out.println("[" + index + "] = " + population);
    }
}