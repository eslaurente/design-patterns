package com.laurente.design.patterns.creational.prototype;

import org.apache.commons.lang3.SerializationUtils;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee john = new Employee("John", new Address("123 London Road", "London", "UK"));

        // Employee chris = john;
        Employee chris = new Employee(john);

        chris.name = "Chris";
        chris.address.streetAddress = "1234 Glisan Street";
        chris.address.city = "Portland";
        chris.address.country = "USA";
        System.out.println(john);
        System.out.println(chris);
        System.out.println();

        // ** Prototype - Serialization **
        Foo foo = new Foo(42, "life");
        Foo foo2 = SerializationUtils.roundtrip(foo);
        foo2.stuff = 1024;
        foo2.whatever = "xyz";
        System.out.println(foo);
        System.out.println(foo2);
    }
}
