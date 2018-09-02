package com.laurente.design.patterns.creational.singleton;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTests {

    /**
     * NOTE: Since SingletonDatabase is coupled with its "database", this does not create an ideal test set up
     */
    @Test
    public void singletonTotalPopulationTest() {
        List<String> cityNames = List.of("Seoul", "Mexico City");
        int totalPopulation = SingletonDatabaseRecordFinder.getPopulation(cityNames);
        assertEquals(17500000 + 17400000, totalPopulation);
    }
}
