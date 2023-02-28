package org.example;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/Задача ВС Java Сбер.csv";
        CitiesDirectory.loadCitiesFromFile(path);

        //Сортировка и вывод списка городов
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

        //Поиск города с наибольшим населением
        /*int index = CitiesDirectory.findMaxPopulationCityIndex();
        long population = CitiesDirectory.getCities().get(index).getPopulation();
        System.out.println("[" + index + "] = " + population);*/

        //Определение количества городов в каждом регионе
        Map<String, Integer> regionsAndCitiesCount = CitiesDirectory.getRegionsAndCitiesCount();
        for (Map.Entry<String, Integer> entry : regionsAndCitiesCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}