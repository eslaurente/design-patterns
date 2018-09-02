package com.laurente.design.patterns.creational.singleton;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTests {

    /**
     * NOTE: Since SingletonDatabase is coupled with its "database", this does not create an ideal test set up
     * NOTE: This is an integration test
     */
    @Test
    public void singletonTotalPopulationIntegrationTest() {
        List<String> cityNames = List.of("Seoul", "Mexico City");
        int totalPopulation = SingletonDatabaseRecordFinder.getPopulation(cityNames);
        assertEquals(17500000 + 17400000, totalPopulation);
    }

    /**
     *  NOTE: Since Database interface follows the Liksov substitution principle and we are applying dependency inversion
     *        principle, we can now properly unit test that 'getPopulation()' method is behaving correctly
     */
    @Test
    public void dependentPopulationUnitTest() {
        DummyDatabase db = new DummyDatabase();
        ConfigurableRecordFinder recordFinder = new ConfigurableRecordFinder(db);
        int expected = 4;
        int result = recordFinder.getPopulation(List.of("alpha", "gamma"));
        assertEquals(expected, result);
    }
}
