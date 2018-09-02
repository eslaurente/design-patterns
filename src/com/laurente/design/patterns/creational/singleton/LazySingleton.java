package com.laurente.design.patterns.creational.singleton;

public class LazySingleton {

    private static LazySingleton instance;

    private LazySingleton() {
    }

//    Note: Add 'synchronized' to prevent race condition - performance hit
//    public static synchronized LazySingleton getInstance() {
//        if (instance == null) {
//            System.out.println("LazySingleton: new instance");
//            instance = new LazySingleton();
//        }
//        else {
//            System.out.println("LazySingleton: current instance");
//        }
//        return instance;
//    }

    // double-checked locking
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    System.out.println("LazySingleton: new instance");
                    instance = new LazySingleton();
                }
            }
        } else {
            System.out.println("LazySingleton: current instance");
        }
        return instance;
    }
}
