package com.laurente.design.patterns.creational.singleton;

import java.util.List;

public class SingletonDatabaseRecordFinder {

    public static int getPopulation(List<String> cityNames) {
        SingletonDatabase db = SingletonDatabase.getInstance();
        return cityNames.stream()
                .mapToInt(db::getPopulation)
                .sum();
    }
}
