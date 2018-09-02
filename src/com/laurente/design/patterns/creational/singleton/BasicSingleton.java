package com.laurente.design.patterns.creational.singleton;

import java.io.Serializable;

public class BasicSingleton implements Serializable {
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

    // Ensures that serialization resolves against this instance, preventing copying
    protected Object readResolve() {
        return INSTANCE;
    }
}
