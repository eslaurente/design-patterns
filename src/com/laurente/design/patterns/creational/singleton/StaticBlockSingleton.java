package com.laurente.design.patterns.creational.singleton;

import java.io.File;
import java.io.IOException;

public class StaticBlockSingleton {

    private static StaticBlockSingleton instance;

    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (IOException e) {
            System.err.println("Failed to create singleton!");;
        }
    }

    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }
}
