package com.laurente.design.patterns.creational.singleton;

import java.io.*;

public class SingletonDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("** Singleton **");
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());
        System.out.println();

        // Problems with basic Singleton:
        // 1. Reflection - you can bypass private constructor using Reflection
        // 2. Serialization - clone object regardless of private constructor

        System.out.println("** Serializing singleton **");
        BasicSingleton singletonToFile = BasicSingleton.getInstance();
        singletonToFile.setValue(111);
        String fileName = "singleton.bin";
        saveToFile(singletonToFile, fileName);

        singleton.setValue(222);
        BasicSingleton singletonFromFile = readFromFile(fileName);
        String output = String.format("'singletonToFile' == 'singletonFromFile: %s | singletonToFile.getValue(): %d | singletonFromFile.getValue(): %s'", singletonToFile == singletonFromFile, singletonToFile.getValue(), singletonFromFile.getValue());
        System.out.println(output);
        System.out.println();

        System.out.println("** Lazy Singleton - threadsafe **");
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();

    }

    public static void saveToFile(BasicSingleton singleton, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    public static BasicSingleton readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton) in.readObject();
        }
    }
}
