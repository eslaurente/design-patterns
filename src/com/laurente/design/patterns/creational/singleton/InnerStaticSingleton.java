package com.laurente.design.patterns.creational.singleton;

public class InnerStaticSingleton {

    private InnerStaticSingleton() {
        System.out.println("InnerStaticSingleton: I am threadsafe");
    }

    private static class Impl {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public static InnerStaticSingleton getInstance() {
        return Impl.INSTANCE;
    }
}
