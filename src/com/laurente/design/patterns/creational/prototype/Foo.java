package com.laurente.design.patterns.creational.prototype;

import java.io.Serializable;
import java.util.List;

public class Foo implements Serializable {
    public int stuff;
    public String whatever;
    public List<String> test;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "stuff=" + stuff +
                ", whatever='" + whatever + '\'' +
                '}';
    }


}
