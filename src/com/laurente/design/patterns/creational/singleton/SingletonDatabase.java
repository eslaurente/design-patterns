package com.laurente.design.patterns.creational.singleton;

import com.google.common.collect.Iterables;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingletonDatabase {
    private Map<String, Integer> capitalCities = new HashMap<>();
    private static final SingletonDatabase INSTANCE = new SingletonDatabase();
    private static int instanceCount = 0;

    private SingletonDatabase() {
        System.out.println("Initializing database...");
        try {
            Path path = Paths.get("assets/capitalCities.txt");
            List<String> lines = Files.readAllLines(path);

            Iterables.partition(lines, 2)
                    .forEach(entry -> capitalCities.put(entry.get(0).trim(), Integer.parseInt(entry.get(1))));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        return instanceCount;
    }

    public static SingletonDatabase getInstance() {
        return INSTANCE;
    }

    public int getPopulation(String name) {
        return capitalCities.get(name);
    }

}