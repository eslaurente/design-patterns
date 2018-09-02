package com.laurente.design.patterns.creational.singleton;

import java.util.List;

public class ConfigurableRecordFinder {

    private Database database;

    public ConfigurableRecordFinder(Database database) {
        this.database = database;
    }

    public int getPopulation(List<String> cityNames) {

        return cityNames.stream()
                .mapToInt(database::getPopulation)
                .sum();
    }
}
