package com.laurente.design.patterns.creational.singleton;

/**
 * NOTE on issues with this approach:
 *  (1) Cannot be serialized without losing data integrity (not all fields are serialized)
 *  (2) Cannot be extended by nature of enums
 */
public enum EnumBasedSingleton {
    INSTANCE;

    private int value;

    EnumBasedSingleton() {
        value = 42;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
