package com.laurente.design.patterns.creational.singleton;

public class BasicSingleton {
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    private int value = 0;

    private BasicSingleton() {}

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
