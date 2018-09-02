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
        BasicSingleton singletonFromFile = (BasicSingleton) readFromFile(fileName);
        String output = String.format("'singletonToFile' == 'singletonFromFile: %s | singletonToFile.getValue(): %d | singletonFromFile.getValue(): %s'", singletonToFile == singletonFromFile, singletonToFile.getValue(), singletonFromFile.getValue());
        System.out.println(output);
        System.out.println();

        System.out.println("** Lazy Singleton - threadsafe **");
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        System.out.println();

        System.out.println("** Inner Static Singleton - inherently threadsafe **");
        InnerStaticSingleton innerStaticSingleton1= InnerStaticSingleton.getInstance();
        InnerStaticSingleton innerStaticSingleton2 = InnerStaticSingleton.getInstance();
        System.out.println();

        System.out.println("** Enum Based Singleton **");
        String enumFileName = "enumBasedSingleton.bin";
//        EnumBasedSingleton enumBasedSingleton1 = EnumBasedSingleton.INSTANCE;
//        enumBasedSingleton1.setValue(1024);
//        saveToFile(enumBasedSingleton1, enumFileName);

        EnumBasedSingleton enumBasedSingleton2 = (EnumBasedSingleton) readFromFile(enumFileName);
//        String enumBasedOutput = String.format("'enumBasedSingleton1' == 'enumBasedSingleton2: %s | enumBasedSingleton1.getValue(): %d | enumBasedSingleton2.getValue(): %s'", enumBasedSingleton1 == enumBasedSingleton2, enumBasedSingleton1.getValue(), enumBasedSingleton2.getValue());
//        System.out.println(enumBasedOutput);
        System.out.println(enumBasedSingleton2.getValue() == 42); // Should be 1024!

    }

    public static void saveToFile(Object singleton, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }
    }

    public static Object readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return in.readObject();
        }
    }
}
