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
        String fileName = "assets/singleton.bin";
        saveToFile(singletonToFile, fileName);

        singleton.setValue(222);
        BasicSingleton singletonFromFile = (BasicSingleton) readFromFile(fileName);
        System.out.println("'singletonToFile' == 'singletonFromFile: " + (singletonToFile == singletonFromFile) + " | singletonToFile.getValue(): " + singletonToFile.getValue() + " | singletonFromFile.getValue(): " + singletonFromFile.getValue() + "'");
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
        String enumFileName = "assets/enumBasedSingleton.bin";
//        EnumBasedSingleton enumBasedSingleton1 = EnumBasedSingleton.INSTANCE;
//        enumBasedSingleton1.setValue(1024);
//        saveToFile(enumBasedSingleton1, enumFileName);

        EnumBasedSingleton enumBasedSingleton2 = (EnumBasedSingleton) readFromFile(enumFileName);
        System.out.println();
//        System.out.println("'enumBasedSingleton1' == 'enumBasedSingleton2: " + (enumBasedSingleton1 == enumBasedSingleton2) + " | enumBasedSingleton1.getValue(): " + enumBasedSingleton1.getValue() + " | enumBasedSingleton2.getValue(): " + enumBasedSingleton2.getValue() + "'");
        System.out.println("enumBasedSingleton2.getValue() == 42: " + (enumBasedSingleton2.getValue() == 42)); // Should be 1024!
        System.out.println();

        System.out.println("** Mono State Singleton **");
        MonoStateSingleton chiefExecutiveOfficer = new MonoStateSingleton();
        chiefExecutiveOfficer.setName("Emerald Laurente");
        chiefExecutiveOfficer.setAge(29);

        MonoStateSingleton anotherCeo = new MonoStateSingleton();
        anotherCeo.setName("Andrew Grimes");
        anotherCeo.setAge(28);
        System.out.println("chiefExecutiveOfficer.getName().equals(anotherCeo.getName()): " + chiefExecutiveOfficer.getName().equals(anotherCeo.getName()));

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
