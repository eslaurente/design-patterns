package com.laurente.design.patterns.creational.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            System.out.println("LazySingleton: new instance");
            instance = new LazySingleton();
        }
        else {
            System.out.println("LazySingleton: current instance");
        }
        return instance;
    }
}
