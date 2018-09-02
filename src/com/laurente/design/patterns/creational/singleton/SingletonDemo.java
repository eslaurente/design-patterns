package com.laurente.design.patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        // ** Singleton **
        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());
        System.out.println();

        //
    }
}
