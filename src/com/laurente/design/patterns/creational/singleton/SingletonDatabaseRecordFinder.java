package com.laurente.design.patterns.creational.singleton;

import java.util.List;

public class SingletonDatabaseRecordFinder {

    public static int getPopulation(List<String> cityNames) {
        int result = 0;
        for (String cityName : cityNames) {
            result += SingletonDatabase.getInstance().getPopulation(cityName);
        }
        return result;
    }
}
